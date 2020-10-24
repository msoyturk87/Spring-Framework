package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    @Autowired
    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    private ExtraSessions extraSessions;
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Java hours "+(30+extraSessions.gethours()));
    }


}
