package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User { // User reserve keyword for postgresql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String username;
    private String password;
    private int active;
    private String roles;
    private String permissions;

    public User(String username, String password,String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.active = 1;
        this.roles = roles;
        this.permissions = permissions;
    }
    // instead of this we can create new class for ROLE and PERMISSION.
    //  In this case we should make Many To Many RelationShip

    /**
     * This methods for taking data as a String and returning
     * all of them
     * with List
     * @return List
     */
    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
    /**
     * This methods for taking data as a String and returning
     * all of them
     * with List
     * @return List
     */
    public List<String> getPermissionList(){
        if(this.permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();

    }
}