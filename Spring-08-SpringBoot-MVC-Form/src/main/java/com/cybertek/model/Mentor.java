package com.cybertek.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Mentor {


    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private boolean graduated;
    private List <String> batch;
    private String company;

}
