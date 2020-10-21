package com.cybertek.services;

import com.cybertek.interfaces.Course;

public class Java implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching 20 hours");
    }

    public void myInitMethod(){

        System.out.println("Executing Init Method");
    }
    public void myDestroyMethod(){

        System.out.println("Destroy  Method");
    }
}
