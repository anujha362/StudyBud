package com.project.studybud.repositories;

import com.project.studybud.entities.Post;
import com.project.studybud.entities.Student;
import com.project.studybud.models.PostTitle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByPostID(Long postID);
    @Query("SELECT p FROM Post p WHERE p.student.cID = :cId AND p.student.sID = :sId " +
            "UNION \n" +
            "SELECT a \n" +
            "  FROM Post a \n" +
            "  JOIN Comment b ON a.postID = b.post.postID \n" +
            " WHERE b.student.cID = :cId AND b.student.sID = :sId ")
    List<Post> findAllByStudent(Long cId, Long sId);

    @Query(value = "SELECT new com.project.studybud.models.PostTitle(p.postID, p.title, p.openType, p.meetingType, p.createdData, s.firstName, s.lastName, count(c.commentID)) \n" +
            "FROM Post p \n" +
            "JOIN Student s ON p.student.cID = s.cID AND p.student.sID = s.sID  \n" +
            "JOIN Student r ON r.cID = :cId AND r.sID  = :sId \n" +
            "LEFT JOIN Comment c ON p.postID = c.post.postID \n" +
            //" WHERE p.openType = 'PUBLIC' OR (p.openType = 'PROGRAM' AND s.deptName = r.deptName)   \n" +
            " group by p.postID, p.title, p.openType, p.meetingType, p.createdData, s.firstName, s.lastName " )
    List<PostTitle> findAllByFilterDefaultWithJPQL(Long cId, Long sId);

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

