package com.project.studybud.repositories;


import com.project.studybud.entities.Course;
import com.project.studybud.entities.CourseID;
import com.project.studybud.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, CourseID> {
    //List<Course> findByCIDAndSID(Long cID, Long sID);

    List<Course> findByStudent(Student student);
    @Query("SELECT c.CourseName FROM Course c " +
            "WHERE c.cID = :cId AND c.sID = :sId")
    List<String> findDistinctCourseNamesByStudentId(Long cId, Long sId);


}
