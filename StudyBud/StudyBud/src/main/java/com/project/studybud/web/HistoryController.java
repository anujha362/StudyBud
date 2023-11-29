package com.project.studybud.web;

import com.project.studybud.entities.Comment;
import com.project.studybud.entities.Post;
import com.project.studybud.entities.Student;
import com.project.studybud.entities.StudentID;
import com.project.studybud.repositories.CommentRepository;
import com.project.studybud.repositories.PostRepository;
import com.project.studybud.repositories.StudentRepository;
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
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

//    public List<Post> findByStudentId(String studId){
//
//        List<Post> unfilteredList = postRepository.findAll();
//        List<Post> filteredList = new ArrayList<>();
//        Post post;
//        Comment comment;
//        for(int i=0; i< unfilteredList.size();i++)
//        {
//            post = unfilteredList.get(i);
//            if(post.getStudent().getSID().equals(studId))
//            {
//                filteredList.add(post);
//            } else {
//
//            List<Comment> unfilteredComments = commentRepository.findAllByPost(post);
//            for(int j=0; j< unfilteredComments.size(); j++){
//                comment = unfilteredComments.get(j);
//                if(comment.getStudent().getSID().equals(studId)){
//
//                }
//            }
//                if()
//            }
//        }
//
//
//    }


    @GetMapping(path = "/history")
    public String History(Model model) {

//
//        StudentID studentID = new StudentID(1000L, 300357917L);
//        Student student1 = new Student();
//        student1.setFirstName("Jane");
//        student1.setLastName("Doe");
//        student1.setCID(1000L);
//        student1.setCID(300357917L);
//        Post post1 = new Post();
//        post1.setStudent(student1);




        return "history";
    }
}
