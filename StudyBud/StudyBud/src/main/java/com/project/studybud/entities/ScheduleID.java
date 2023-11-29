package com.project.studybud.entities;

import java.io.Serializable;
import java.sql.Time;

public class ScheduleID implements Serializable {

    private Long cID;
    private Long sID;
    private Integer day;
    private Time startTime;

    public ScheduleID(Long cID, Long sID, Integer day, Time startTime) {
        this.cID = cID;
        this.sID = sID;
        this.day = day;
        this.startTime = startTime;
    }
}
