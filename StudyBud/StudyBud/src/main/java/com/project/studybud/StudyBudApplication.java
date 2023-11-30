package com.project.studybud;

import com.project.studybud.entities.College;
import com.project.studybud.entities.Student;
import com.project.studybud.repositories.CollegeRepository;
import com.project.studybud.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudyBudApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyBudApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository, CollegeRepository collegeRepository){
//        return args -> {
//            College college = new College(1000L, "Douglas College", "","");
//            collegeRepository.save(college);
//            studentRepository.save(new Student(1000L, college, 300357917L, "Jaycee", "Kim","",""));
//
//        };
//    }
}
