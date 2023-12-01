package com.project.studybud.web;

import com.project.studybud.common.CommonConstants;
import com.project.studybud.entities.Comment;
import com.project.studybud.entities.Post;
import com.project.studybud.entities.Student;
import com.project.studybud.entities.StudentID;
import com.project.studybud.models.AlertMessage;
import com.project.studybud.repositories.CommentRepository;
import com.project.studybud.repositories.PostRepository;
import com.project.studybud.repositories.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PostController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    AlertController alertController;

    @GetMapping(path = "/CreatePostTest")
    public String CreatePostTest(Model model) {

        Post testPost = new Post();

        testPost.setTitle("Test");

        StudentID studentID = new StudentID(1000L, 300357917L);
        Student student = studentRepository.findById(studentID).orElse(null);
        testPost.setStudent(student);

        testPost.setHours(4);
        testPost.setHeadcount(4);
        testPost.setDetail("Insert Test Data");

        testPost.setStatus(CommonConstants.PostStatus.OPEN);
        testPost.setOpenType(CommonConstants.PostOpenType.PUBLIC);
        testPost.setMeetingType(CommonConstants.PostMeetingType.IN_PERSON);

        testPost.setMeetingDate(CommonConstants.localDate);
        testPost.setMeetingTime(CommonConstants.localTime);

        testPost.setCreatedData(CommonConstants.localDateTime);
        testPost.setModifiedData(CommonConstants.localDateTime);

        postRepository.save(testPost);

        return "redirect:index";
    }

    @GetMapping(path = "/PostDetail")
    public String movePostDetail(Model model, @RequestParam final long id, HttpServletRequest request) {

        HttpSession session = request.getSession();
        AlertMessage alertMessage = null;

        Post postDetail = new Post();
        postDetail = postRepository.findById(id).orElse(null);
        if(postDetail == null) {
            //Show alert message and move to List page
            alertMessage = new AlertMessage();
            alertMessage.setMessage("Post does not exist");
            alertMessage.setRedirectUrl(CommonConstants.RedirectUrls.POSTDETAIL + "?id=1");
            alertMessage.setHttpMethod(CommonConstants.HttpMetthod.GET);

            return alertController.messageRedirect(alertMessage, model);

        } else {
            model.addAttribute("detail", postDetail);
            session.setAttribute("studentId",postDetail.getStudent().getSID());
            session.setAttribute("CollegeId",postDetail.getStudent().getCID());

            //Registered Comment
            List<Comment> commentList = new ArrayList<>();
            commentList = getCommentList(postDetail);
            model.addAttribute("commentList", commentList);

            //New Comment
            Comment newComment = new Comment();
            newComment.setPost(postDetail);
            model.addAttribute("newComment", newComment);
        }

        return "postDetail";
    }

    @PostMapping(path = "/PostDetail/SaveComment")
    public String saveComment(Model model, HttpServletRequest request, Comment newComment, RedirectAttributes re ) {
        AlertMessage alertMessage = null;

        try {
            Comment comment = null;

            Long postId = null;
            String content = null;
            Long sID = null;
            Long cID = null;

            postId = newComment.getPost().getPostID();
            content = newComment.getDetail();

            HttpSession session = request.getSession();

            sID = (Long)session.getAttribute("studentId");
            cID = (Long)session.getAttribute("CollegeId");

            Post postDetail = new Post();
            postDetail = postRepository.findById(postId).orElse(null);

            StudentID studentID = new StudentID(cID, sID);
            Student student = studentRepository.findById(studentID).orElse(null);

            comment = new Comment();

            comment.setPost(postDetail);
            comment.setStudent(student);
            comment.setDetail(content);
            comment.setStatus(CommonConstants.ApplyStatus.APPLY);
            comment.setCreatedData(CommonConstants.localDateTime);
            comment.setModifiedData(CommonConstants.localDateTime);

            commentRepository.save(comment);

            re.addAttribute("id", postDetail.getPostID());

        } catch ( Exception e) {
            e.printStackTrace();
            alertMessage = new AlertMessage();
            alertMessage.setMessage(e.getMessage());
            alertMessage.setRedirectUrl(CommonConstants.RedirectUrls.POSTDETAIL + "?id=1");
            alertMessage.setHttpMethod(CommonConstants.HttpMetthod.GET);
        }

        return "redirect:/PostDetail";
    }

    @GetMapping(path = {"/PostDetail/AcceptComment"})
    public String acceptComment(Model model, HttpServletRequest request, @RequestParam final long id, RedirectAttributes re ) {

        Comment comment = null;
        AlertMessage alertMessage = null;
        try {
            comment = commentRepository.findById(id).orElse(null);
            if(comment == null) {
                alertMessage = new AlertMessage();
                alertMessage.setMessage("Post does not exist");
                alertMessage.setRedirectUrl(CommonConstants.RedirectUrls.POSTDETAIL + "?id=");
                alertMessage.setHttpMethod(CommonConstants.HttpMetthod.GET);

                return alertController.messageRedirect(alertMessage, model);
            } else {

                //Check headcount of the meeting room in case of acceptance
                int approvalCnt = commentRepository.getAcceptedCommentCount(comment.getPost().getPostID());
                int maxGrpCnt = comment.getPost().getHeadcount();
                if(approvalCnt + 1 >= maxGrpCnt) {
                    alertMessage = new AlertMessage();
                    alertMessage.setMessage("Cannot approve that the meeting is full");
                    alertMessage.setRedirectUrl(CommonConstants.RedirectUrls.POSTDETAIL + "?id=" + comment.getPost().getPostID());
                    alertMessage.setHttpMethod(CommonConstants.HttpMetthod.GET);

                    return alertController.messageRedirect(alertMessage, model);
                }
                //Update status
                comment.setStatus(CommonConstants.ApplyStatus.ACCEPT);
                int updatedCnt = commentRepository.updateAcceptedComment(comment.getPost().getPostID(), comment.getStudent().getSID(), comment.getStatus());

                re.addAttribute("id", comment.getPost().getPostID());
            }
        } catch (Exception e) {
            e.printStackTrace();
            alertMessage = new AlertMessage();
            alertMessage.setMessage(CommonConstants.ErrorMessage.INTERNAL_ERROR);
            alertMessage.setRedirectUrl(CommonConstants.RedirectUrls.POSTDETAIL + "?id="+ comment.getPost().getPostID());
            alertMessage.setHttpMethod(CommonConstants.HttpMetthod.GET);

            return alertController.messageRedirect(alertMessage, model);
        }

        return "redirect:/PostDetail";
    }

    public List<Comment> getCommentList(Post postDetail) {
        return commentRepository.findAllByPost(postDetail);
    }


    @GetMapping(path = "/Dashboard")
    public String chartTest(Model model) {
        List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
        Map<Object , Object> map1 = new HashMap<Object,Object>();

        map1.put("label", "Chrome");

        map1.put("y", 51.08);

        dataPoints1.add(map1);



        Map<Object , Object> map2 = new HashMap<Object,Object>();

        map2.put("label", "Internet Explorer");

        map2.put("y", 27.34);

        dataPoints1.add(map2);



        Map<Object , Object> map3 = new HashMap<Object,Object>();

        map3.put("label", "Firefox");

        map3.put("y", 10.62);

        dataPoints1.add(map3);

        model.addAttribute("dataPointsList", dataPoints1);

        return "dashboard";
    }

}
