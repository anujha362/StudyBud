package com.project.studybud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer Time;

    private Integer Monday;
    private Integer Tuesday;
    private Integer Wednesday;
    private Integer Thursday;
    private Integer Friday;
    private Integer Saturday;
    private Integer Sunday;


}

