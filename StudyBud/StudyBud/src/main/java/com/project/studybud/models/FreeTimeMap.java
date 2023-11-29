package com.project.studybud.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FreeTimeMap {
    private Integer time;
    private TimeObj timbObj;
    @Getter
    @Setter
    public class TimeObj {
        private Integer time;
        private String dayofWeek;
        private Integer flag;
    }
}
