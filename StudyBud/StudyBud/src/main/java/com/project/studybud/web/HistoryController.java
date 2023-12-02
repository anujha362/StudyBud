package com.project.studybud.web;

import com.project.studybud.common.CommonConstants;
import com.project.studybud.entities.*;
import com.project.studybud.models.ReviewList;
import com.project.studybud.repositories.CommentRepository;
import com.project.studybud.repositories.PostRepository;
import com.project.studybud.repositories.ReviewRepository;
import com.project.studybud.repositories.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class HistoryController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PostRepository PostRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @GetMapping(path = "/history")
    public String History(Model model, HttpServletRequest request) {

        //StudentID studentID = new StudentID(1000L, 300357917L);

        //List<Post> postHistory = PostRepository.findAllByStudent(1000L, 300357917L);

        HttpSession session = request.getSession();
        Long cID = (Long) session.getAttribute("CollegeId");
        Long sID = (Long) session.getAttribute("studentId");

        List<ReviewList> postHistory =  reviewRepository.findAllByStudentWithJPQL(cID, sID);

        model.addAttribute("History", postHistory);

        return "history";
    }

    @GetMapping(path = "/saveRate")
    public String SaveRate(Model model, HttpServletRequest request, @RequestParam("rID") Long rid , @RequestParam("pID") Long pid , @RequestParam("rateValue") Double rateValue ) {
        HttpSession session = request.getSession();
        Long cID = (Long) session.getAttribute("CollegeId");
        Long sID = (Long) session.getAttribute("studentId");

        Review review = reviewRepository.findById(rid).orElse(null);
        if(review == null){

//            Post post = new Post();
//            post.setPostID(pid);
            Post post = PostRepository.findById(pid).orElse(null);
            post.setStatus("review");
            PostRepository.save(post);

            Student student = new Student();
            student.setCID(cID);
            student.setSID(sID);
            Review newReview = new Review();

            newReview.setPost(post);
            newReview.setStudent(student);
            newReview.setRate(rateValue);
            newReview.setCreatedData(CommonConstants.localDateTime);
            newReview.setModifiedData(CommonConstants.localDateTime);

            reviewRepository.save(newReview);
        }else{
            review.setRate(rateValue);

            reviewRepository.save(review);
        }



        return "redirect:history";
    }
}
