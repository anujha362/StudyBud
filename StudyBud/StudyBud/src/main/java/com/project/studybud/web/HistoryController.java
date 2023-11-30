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

    public List<Post> findByStudentId(Long studId){



        Student student1 = new Student();
        student1.setFirstName("Jane");
        student1.setLastName("Doe");
        student1.setCID(1000L);
        student1.setCID(300357917L);


        Student student2= new Student();
        student2.setFirstName("Jackson");
        student2.setLastName("Danger");
        student2.setCID(2000L);
        student2.setCID(300357917L);

        Post post1 = new Post();
        post1.setStudent(student1);
        post1.setTitle("Math");
        post1.setPostID(5555L);

        Post post2 = new Post();
        post2.setStudent(student2);
        post2.setTitle("Art");
        post2.setPostID(6666L);
        Comment comment1= new Comment();
        comment1.setStudent(student1);
        comment1.setPost(post2);


        List<Post> unfilteredList = new ArrayList<>();
        unfilteredList.add(post1);
        unfilteredList.add(post2);
//                postRepository.findAll();
        List<Post> filteredList = new ArrayList<>();


        Post post;
        Comment comment;

        for (Post id : unfilteredList) {
            post = id;
            if (post.getStudent().getSID().equals(studId)) {
                filteredList.add(post);
            } else {

                List<Comment> unfilteredComments = new ArrayList<>();
                unfilteredComments.add(comment1);
//                        commentRepository.findAllByPost(post);
                for (Comment unfilteredComment : unfilteredComments) {
                    comment = unfilteredComment;
                    if (comment.getStudent().getSID().equals(studId)) {
                        filteredList.add(comment.getPost());
                    }
                }

            }
        }

        return filteredList;
    }


    @GetMapping(path = "/history")
    public String History(Model model, Long studentId) {

    List<Post> postHistory= findByStudentId(studentId);

    model.addAttribute("History", postHistory);

        return "history";
    }
}
