package com.project.studybud.web;

import com.project.studybud.models.AlertMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AlertController {
    public String messageRedirect(AlertMessage alertMessage, Model model) {
        model.addAttribute("alertMessage",alertMessage);
        return "alert";
    }

}
