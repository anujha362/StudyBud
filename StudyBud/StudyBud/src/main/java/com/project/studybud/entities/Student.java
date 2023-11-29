package com.project.studybud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(StudentID.class)
public class Student {

    @Id
    private Long cID;

    @ManyToOne
    @MapsId
    @JoinColumn(name= "cID")
    College college;

    @Id
    private Long sID;

    private String firstName;
    private String lastName;

    private String deptName;
    private String email;


}