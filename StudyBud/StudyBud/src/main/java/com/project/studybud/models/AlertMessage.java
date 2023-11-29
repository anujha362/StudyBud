package com.project.studybud.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlertMessage {
    private String message;
    private String redirectUrl;
    private String httpMethod;

}
