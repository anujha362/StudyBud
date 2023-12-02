package com.project.studybud.web;

import com.project.studybud.entities.Comment;
import com.project.studybud.entities.Post;
import com.project.studybud.entities.Student;
import com.project.studybud.entities.StudentID;
import com.project.studybud.models.ReviewList;
import com.project.studybud.repositories.CommentRepository;
import com.project.studybud.repositories.PostRepository;
import com.project.studybud.repositories.ReviewRepository;
import com.project.studybud.repositories.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
