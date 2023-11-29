package com.project.studybud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class College {
    @Id
    private Long cID;
    private String cName;
    private String billingAddress;
    private String email;


}
