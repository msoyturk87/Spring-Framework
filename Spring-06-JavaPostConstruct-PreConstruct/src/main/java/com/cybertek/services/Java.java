package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
@Component
public class Java implements Course {


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching Java hours 56");
    }

    @PostConstruct
    public void postConstruct(){

        System.out.println("PostConstruct");


    }

    @PreDestroy
    public void postDestroy(){

        System.out.println("PreDestroy");


    }


}
