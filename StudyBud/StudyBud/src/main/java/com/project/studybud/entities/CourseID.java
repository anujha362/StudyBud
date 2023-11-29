package com.project.studybud.entities;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class CourseID implements Serializable {

    private Long cID;
    private Long sID;
    private String CourseID;

    public CourseID(Long cID, Long sID, String CourseID) {
        this.cID = cID;
        this.sID = sID;
        this.CourseID = CourseID;
    }
}
