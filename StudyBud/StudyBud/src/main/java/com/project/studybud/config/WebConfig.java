package com.project.studybud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //Exclude login, logout path
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new StudyInterceptor())
                .excludePathPatterns("/css/**", "/images/**", "/js/**");
    }

}
