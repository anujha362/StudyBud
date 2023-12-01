package com.project.studybud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name= "cID"),
            @JoinColumn(name= "sID")
    })
    private Student student;

    private String title;
    private String meetingType; //in-person or online
    private String openType; //public, same program, same course

    private LocalDate meetingDate;

    private LocalTime meetingTime;

    private Integer hours;
    private Integer headcount;
    private String detail;
    private String status;

    private LocalDateTime createdData;

    private LocalDateTime modifiedData;

    private Integer studentRating;

}
