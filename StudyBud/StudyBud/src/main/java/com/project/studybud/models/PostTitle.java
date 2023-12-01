package com.project.studybud.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class PostTitle {

    private Long postID;
    private String title;
    private String openType; //public, same program, same course
    private String meetingType; //in-person or online
    private LocalDateTime createdData;
    private String firstName;
    private String lastName;
    private Long cmtCount;

    public PostTitle(Long postID, String title, String openType, String meetingType, LocalDateTime createdData, String firstName, String lastName, Long cmtCount) {
        this.postID = postID;
        this.title = title;
        this.openType = openType;
        this.meetingType = meetingType;
        this.createdData = createdData;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cmtCount = cmtCount;
    }
}
