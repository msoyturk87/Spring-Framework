package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Selenium implements Course {




    ExtraSessions extraSessions;


    public void setExtraSessions(ExtraSessions extraSessions) {
        this.extraSessions=extraSessions;
    }

    public ExtraSessions getExtraSessions(){
        return extraSessions;
    }

    @Override
    public void getTeachingHours()   {
        System.out.println("Weekly teaching hours :"+( 15+extraSessions.getHours()));

    }
}
