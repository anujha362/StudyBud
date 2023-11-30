package com.project.studybud.entities;

import java.io.Serializable;

public class ScheduleID implements Serializable {

    private Long cID;
    private Long sID;
    private Integer Time;

    public ScheduleID(Long cID, Long sID, Integer time) {
        this.cID = cID;
        this.sID = sID;
        Time = time;
    }
}
