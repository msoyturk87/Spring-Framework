package com.services;

import com.interfaces.Course;
import com.interfaces.ExtraSessions;

public class Java implements Course {

    ExtraSessions extraSessions;


    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }



    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : "+(20+ extraSessions.getHours()));
    }
}
