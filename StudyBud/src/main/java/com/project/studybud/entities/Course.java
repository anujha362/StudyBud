package com.project.studybud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(CourseID.class)
public class Course {
    @Id
    private Long cID;

    @Id
    private Long sID;

    @ManyToOne
    @MapsId
    @JoinColumns({
            @JoinColumn(name= "cID"),
            @JoinColumn(name= "sID")
    })
    private Student student;

    @Id
    private String CourseID;

    private String CourseName;
}
