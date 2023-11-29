package com.project.studybud.repositories;


import com.project.studybud.entities.Interest;
import com.project.studybud.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepository extends JpaRepository<Interest,Long> {
    List<Interest> findByStudent(Student student);
}
