package com.project.studybud.repositories;

import com.project.studybud.entities.Post;
import com.project.studybud.entities.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByPostID(Long postID);

    @Override
    List<Post> findAll();

//    @Query("SELECT DISTINCT c.CourseName  FROM Course c")
//    List<String> findDistinctStudentCourses();

    @Query("SELECT DISTINCT s.deptName FROM Student s")
    String findDistinctStudentPrograms();

//
//    List<Post> findPostByMeetingTypeContainingIgnoreCaseAndStudentDeptName(String meetingType, String student_deptName);
//
//    @Query("SELECT p FROM Post p JOIN Course c ON p.student.sID = c.student.sID WHERE c.CourseName = :courseName")
//    List<Post> getPostsByCourse(@Param("courseName") String courseName);
@Query("SELECT p FROM Post p " +
        "JOIN Course c ON p.student.sID = c.student.sID " +
        "WHERE (:courseName IS NULL OR c.CourseName = :courseName) " +
        "AND (:programName IS NULL OR p.student.deptName = :programName) " +
        "AND (:meetingType IS NULL OR p.meetingType = :meetingType)"+
         "AND (:openType is NULL OR p.openType=:openType)")
List<Post> getCombinedFilteredPosts(
        @Param("courseName") String courseName,
        @Param("programName") String programName,
        @Param("meetingType") String meetingType,
        @Param ("openType") String openType);
}

