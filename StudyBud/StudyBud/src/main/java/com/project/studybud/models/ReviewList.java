package com.project.studybud.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewList {
    private Long reviewID;
    private Long postID;
    private Long cID;
    private Long sID;
    private String firstName;
    private String lastName;
    private String title;

    private Double rate;

    public ReviewList(Long reviewID, Long postID, Long cID, Long sID, String firstName, String lastName, String title, Double rate) {
        this.reviewID = reviewID;
        this.postID = postID;
        this.cID = cID;
        this.sID = sID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.rate = rate;
    }
}
