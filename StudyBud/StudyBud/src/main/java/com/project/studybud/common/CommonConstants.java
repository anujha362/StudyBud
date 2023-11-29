package com.project.studybud.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CommonConstants {

    public class PostStatus {
        public static final String OPEN = "Open";
        public static final String CONFIRM = "Confirmed";
        public static final String CLOSED = "Closed";
    }

    public class PostOpenType {
        public static final String PUBLIC = "PUBLIC";
        public static final String SAME_COURSE = "SAME COURSE";
        public static final String SAME_PROGRAM = "SAME PROGRAM";
    }

    public class PostMeetingType {
        public static final String IN_PERSON = "IN-PERSON";
        public static final String ONLINE = "ONLINE";
    }

    public class ApplyStatus {
        public static final String APPLY = "APPLIED";
        public static final String ACCEPT = "ACCEPTED";
    }

    public class HttpMetthod {
        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }

    public static final LocalDate localDate = LocalDate.now();
    public static final LocalTime localTime = LocalTime.now();
    public static final LocalDateTime localDateTime = LocalDateTime.now();

    public class RedirectUrls {
        public static final String POSTDETAIL = "/PostDetail";
        public static final String INDEX = "/index";
    }

    public class ErrorMessage {
        public static final String INTERNAL_ERROR = "Internal Error";
    }


}


