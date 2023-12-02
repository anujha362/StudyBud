package com.project.studybud.repositories;


import com.project.studybud.entities.Review;
import com.project.studybud.models.PostTitle;
import com.project.studybud.models.ReviewList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT new com.project.studybud.models.ReviewList(p.postID, p.student.cID, p.student.sID, p.student.firstName, p.student.lastName, p.title, r.rate) \n" +
            "FROM Post p " +
            "LEFT JOIN Review r ON p.postID = r.post.postID AND p.student.cID = r.student.cID AND p.student.sID = r.student.sID \n" +
            "WHERE p.student.cID = :cId AND p.student.sID = :sId " +
            "UNION \n" +
            "SELECT new com.project.studybud.models.ReviewList(a.postID, a.student.cID, a.student.sID, a.student.firstName, a.student.lastName, a.title, v.rate) \n" +
            "  FROM Post a \n" +
            "  JOIN Comment b ON a.postID = b.post.postID \n" +
            "LEFT JOIN Review v ON a.postID = v.post.postID AND a.student.cID = v.student.cID AND a.student.sID = v.student.sID \n" +
            " WHERE b.student.cID = :cId AND b.student.sID = :sId ")
    List<ReviewList> findAllByStudentWithJPQL(Long cId, Long sId);
}
