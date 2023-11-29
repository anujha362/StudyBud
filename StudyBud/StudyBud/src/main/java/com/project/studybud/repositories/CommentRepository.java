package com.project.studybud.repositories;

import com.project.studybud.entities.Comment;
import com.project.studybud.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);

    @Query("SELECT COUNT(DISTINCT C.student.sID) FROM Comment C WHERE C.post.postID = :postId AND C.status = 'ACCEPTED' ")
    Integer getAcceptedCommentCount(Long postId);

    @Modifying
    @Transactional
    @Query("UPDATE Comment set status = :status WHERE post.postID = :postId AND student.sID = :sID")
    Integer updateAcceptedComment(Long postId, Long sID, String status);
}
