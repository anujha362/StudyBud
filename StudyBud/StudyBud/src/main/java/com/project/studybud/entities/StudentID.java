package com.project.studybud.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class StudentID implements Serializable {
    private Long cID;
    private Long sID;
    
    public StudentID(Long cID, Long sID) {
        this.cID = cID;
        this.sID = sID;
    }


}
