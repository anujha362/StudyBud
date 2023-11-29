package com.project.studybud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ScheduleID.class)
public class Schedule {
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
    private Integer day;

    @Id
    private Time startTime;

    private Time endTime;

}

