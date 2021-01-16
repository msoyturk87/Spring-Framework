package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private int active;
    private String roles;
    private String permission;


    public User(String username, String password,String roles, String permission) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permission = permission;
    }

    public List<String> getRoleList(){

        if(this.roles.length()>0){

            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermission(){

        if(this.permission.length()>0){

            return Arrays.asList(this.permission.split(","));
        }
        return new ArrayList<>();
    }
}
