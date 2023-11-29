package com.project.studybud.web;

import com.project.studybud.entities.Post;
import com.project.studybud.repositories.PostRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    @Autowired
    private PostRepository postRepository;
    static int num = 0;

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }
//    List<String> getDistinctMeetingTypes() {
//        return postRepository.findDistinctMeetingTypes();
//    }

    List<String> getDistinctStudentCourses() {
        return postRepository.findDistinctStudentCourses();
    }
    List<String> getDistinctStudentPrograms(){
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
            @RequestParam(name = "studentProgram", required = false) String studentProgram,
            @RequestParam(name = "studentCourse", required = false) String studentCourse,
            Model model) {
        List<String> distinctCourseNames = getDistinctStudentCourses();
        List<String> distinctStudentPrograms = getDistinctStudentPrograms();
        List<Post> filteredPosts = filterPosts(meetingType,openType,studentProgram,studentCourse);
        model.addAttribute("filteredPosts", filteredPosts);
        model.addAttribute("distinctStudentCourses", distinctCourseNames);
        model.addAttribute("distinctStudentPrograms", distinctStudentPrograms);

        return "board";
    }
    @GetMapping(path = "/createpost")
    public String createPost(Model model) {

        model.addAttribute("post", new Post());

        return "createpost";
    }


    @PostMapping (path = "postsave")
    public String postSave(Model model, Post post, BindingResult bindingResult, ModelMap modelMap, HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            return "createpost";
        } else {
            postRepository.save(post);

            if (num == 2) {
                modelMap.put("e", 2);
                modelMap.put("a", 0);

            } else {
                modelMap.put("a", 1);
                modelMap.put("e", 0);
            }

            return "redirect:board";
        }

    }



    @GetMapping(path = "/editpost")
    public String EditPost(Model model) {

        return "editpost";
    }


    @GetMapping(path = "/profile")
    public String Profile(Model model) {

        return "profile";
    }

}
