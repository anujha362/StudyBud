package com.project.studybud.repositories;


import com.project.studybud.entities.Student;
import com.project.studybud.entities.StudentID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, StudentID> {

}
