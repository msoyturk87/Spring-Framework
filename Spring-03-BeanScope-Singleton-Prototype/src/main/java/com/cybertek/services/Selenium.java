package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Selenium implements Course {

    @Override
    public void getTeachingHours()   {
        System.out.println("Weekly teaching hours : 15");

    }
}
