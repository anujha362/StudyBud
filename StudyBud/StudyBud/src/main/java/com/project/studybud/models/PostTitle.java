package com.project.studybud.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostTitle {

    private Long postID;
    private String title;
    private String meetingType; //in-person or online
    private String openType; //public, same program, same course
}
