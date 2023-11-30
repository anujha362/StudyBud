package com.project.studybud.web;

import com.project.studybud.common.CommonConstants;
import com.project.studybud.entities.Student;
import com.project.studybud.entities.StudentID;
import com.project.studybud.models.AlertMessage;
import com.project.studybud.repositories.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    AlertController alertController;

    @GetMapping(path = {"/login","/login/index"})
    public String getLogin(Model model, HttpServletRequest request) { //HttpServletRequest request is essential to get session info
        AlertMessage alertMessage = null;
        //If session is expired, show alert message and redirect to "/login"
        if(request.getRequestURL().toString().contains("/index")) {
            alertMessage = new AlertMessage();
            alertMessage.setMessage("Session has been expired, please retry to login");
            alertMessage.setRedirectUrl(CommonConstants.RedirectUrls.LOGIN);
            alertMessage.setHttpMethod(CommonConstants.HttpMetthod.GET);

            return alertController.messageRedirect(alertMessage, model);
        }

        // How to use HttpServletRequest request session info
        //HttpSession session = request.getSession();

        //Get session value
        //session.getAttribute("studentId").toString()
        //session.getAttribute("CollegeId").toString()
        //session.getAttribute("Email").toString()

        Student student = new Student();
        model.addAttribute("student", student);

        return "login";
    }

    @PostMapping(path = "/login")
    public String doLogin(Model model, @ModelAttribute("student") Student student, HttpServletRequest request) {
        AlertMessage alertMessage = null;

        try {
            StudentID studentID = new StudentID(1000L, student.getSID());

            Student user = studentRepository.findById(studentID).orElse(null);

            if(user == null) {
                //Show alert message and move to List page
                alertMessage = new AlertMessage();
                alertMessage.setMessage("Student info does not exist. Please check your Student Id");
                alertMessage.setRedirectUrl(CommonConstants.RedirectUrls.LOGIN);
                alertMessage.setHttpMethod(CommonConstants.HttpMetthod.GET);

                return alertController.messageRedirect(alertMessage, model);
            }

            HttpSession session = request.getSession();
            //Set session info and max interval
            session.setAttribute("studentId",user.getSID());
            session.setAttribute("CollegeId",user.getCID());
            session.setAttribute("Email",user.getEmail());
            session.setMaxInactiveInterval(60*600);

        } catch (Exception e) {
            e.printStackTrace();
            alertMessage = new AlertMessage();
            alertMessage.setMessage("Error occurred during login process. Please contact administrator");
            alertMessage.setRedirectUrl(CommonConstants.RedirectUrls.LOGIN);
            alertMessage.setHttpMethod(CommonConstants.HttpMetthod.GET);
        }

        return "redirect:/index";
    }
}
