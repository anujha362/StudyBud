package com.project.studybud.web;

import com.project.studybud.common.CommonConstants;
import com.project.studybud.entities.Post;
import com.project.studybud.entities.Student;
import com.project.studybud.repositories.CourseRepository;
import com.project.studybud.repositories.PostRepository;
import com.project.studybud.repositories.StudentRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    static int num = 0;

    public Post getPostById(Long postId) {

        return postRepository.findById(postId).orElse(null);
    }

    List<String> getDistinctStudentCourses(long studentID) {

        return courseRepository.findDistinctCourseNamesByStudentId(studentID);
    }
    String getDistinctStudentPrograms(){

        return postRepository.findDistinctStudentPrograms();
    }

    public List<Post> filterPosts(String meetingType,  String openType,String student_deptName,String student_course) {
        // Implement filtering logic based on various criteria
        // Use the provided criteria to filter the posts
        return postRepository.getCombinedFilteredPosts(student_course,student_deptName,meetingType,openType);
    }


    @GetMapping(path = "/board")
    public String Board(Model model) {
        List<Post> post= postRepository.findAll();
        model.addAttribute("Post",post);
        return "board";
    }
    @GetMapping(path = "/displayPost")
    public String displayPost(@PathVariable Long postId, Model model) {
        Post posts = getPostById(postId);
        model.addAttribute("posts", posts);
        return "displayPost";
    }
    @PostMapping("/board/filter")
    public String filterPosts(
            @RequestParam(name = "meetingType", required = false) String meetingType,
            @RequestParam(name = "openType", required = false) String openType,
            @RequestParam(name = "studentCourse", required = false) String studentCourse,
            Model model,long postID) {
        String studentProgram = getDistinctStudentPrograms();
        Post posts = getPostById(postID);
        List<String> distinctCourseNames = getDistinctStudentCourses(posts.getStudent().getSID());
        List<Post> filteredPosts = filterPosts(meetingType,openType,studentProgram,studentCourse);
        model.addAttribute("filteredPosts", filteredPosts);
        model.addAttribute("distinctStudentCourses", distinctCourseNames);

        return "board";
    }
    @GetMapping(path = "/createpost")
    public String createPost(Model model) {

        model.addAttribute("post", new Post());

        return "createpost";
    }


    @PostMapping (path = "/postsave")
    public String postSave(Model model,  Post post, BindingResult bindingResult, ModelMap modelMap,
                           HttpSession httpSession, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "createpost";
        } else {
            HttpSession session = request.getSession();
            Long cID = (Long) session.getAttribute("CollegeId");
            Long sID = (Long) session.getAttribute("studentId");

            Student student = new Student();
            student.setCID(cID);
            student.setSID(sID);
            post.setStudent(student);
            post.setCreatedData(CommonConstants.localDateTime);
            post.setModifiedData(CommonConstants.localDateTime);
            postRepository.save(post);

            return "redirect:board";

        }

    }



    @GetMapping(path = "/editpost/{id}")
    public String EditPost(@PathVariable("id") Long id,
                           Model model, HttpSession httpSession) {

        httpSession.setAttribute("info", 0);

        Post post = postRepository.findById(id).orElse(null);
        if(post == null) throw new RuntimeException("Post does not exist");
        model.addAttribute("post", post);

        return "editpost";
    }


    @GetMapping(path = "/profile")
    public String Profile(Model model) {

        return "profile";
    }

}
