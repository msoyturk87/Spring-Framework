package com.services;

import com.interfaces.Course;
import com.interfaces.ExtraSessions;

public class Java implements Course {

    ExtraSessions extraSessions;


    public void setExtraSessions(ExtraSessions extraSessions) {
        this.extraSessions=extraSessions;
    }

    public ExtraSessions getExtraSessions(){
        return extraSessions;
    }
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : " + (20 + extraSessions.getHours()));
    }


}


