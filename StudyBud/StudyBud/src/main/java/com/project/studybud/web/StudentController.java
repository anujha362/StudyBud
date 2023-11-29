package com.project.studybud.web;

import com.project.studybud.entities.Course;
import com.project.studybud.entities.Interest;
import com.project.studybud.entities.Student;
import com.project.studybud.entities.StudentID;
import com.project.studybud.repositories.CourseRepository;
import com.project.studybud.repositories.InterestRepository;
import com.project.studybud.repositories.StudentRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@SessionAttributes({"a","e"})
@Controller
@AllArgsConstructor
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InterestRepository interestRepository;
    static int num = 0;

    @GetMapping(path = "/index")
    public String students(Model model) {

        StudentID studentID = new StudentID(1000L, 300357917L);

        Student student = studentRepository.findById(studentID).orElse(null);

        List<Course> courses = courseRepository.findByStudent(student);
//        List<Course> courses = Arrays.asList(
//                new Course(1000l,300357917L,student,"100","DSA"),
//                new Course(1000l,300357917L,student,"101","EL"),
//                new Course(1000l,300357917L,student,"102","Cyber")
//                // Add more courses as needed
//        );
        List<Interest> interests=interestRepository.findByStudent(student);

        model.addAttribute("Student", student);
        model.addAttribute("Courses", courses);
        model.addAttribute("Interest", interests);
        return "profile";
    }
    @GetMapping("/delete")
    public String delete(Long id){
        interestRepository.deleteById(id);
        return "redirect:/profile";
    }

    @PostMapping("/formInterests")
    public String formInterest(Model model){
        model.addAttribute("Interest", new Interest());
        return "formInterests";
    }

    @PostMapping(path="/save")
    public String save(Model model, Interest interest,
                       BindingResult bindingResult, ModelMap mm, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "formInterests";
        } else {
            Student stu = new Student();
            stu.setCID(1000L);
            stu.setSID( 300357917L);
            studentRepository.save(stu);
            interest.setStudent(stu);

            interestRepository.save(interest);
            if (num == 2) {
                mm.put("e", 2);
                mm.put("a", 0);
            } else {
                mm.put("a", 1);
                mm.put("e", 0);
            }
            return "redirect:/index";
        }
    }

}
