package com.project.studybud.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class StudyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("===== Pre-Handler ===");
        log.debug("Request URI ===> " + request.getRequestURI());

        //exclude session check to avoid infinite loop
        if(request.getRequestURL().toString().contains("/index")
            || request.getRequestURL().toString().contains("/login")
                || request.getRequestURL().toString().contains("/logout")) {
            return true;
        }

        HttpSession session = request.getSession();

        //Check if session is expired. if yes, then redirect to login page
        if(session.getAttribute("studentId") == null) {
            session.invalidate();
            log.debug("Session has been expired!!");
            response.sendRedirect(request.getContextPath() + "/login/index");
        }

        return true;

//        HttpSession session = request.getSession();
//        if(session != null) {
//            Long sID = (Long)session.getAttribute("studentId");
//            if(sID != null) {
//                return true;
//            }
//        }
//
//        //return to login page if there is no session studentId
//        log.debug("Session studentId is null");
//        response.sendRedirect(request.getContextPath() + "/indexLogin");
//
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("===== Post-Handler ===");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

}
