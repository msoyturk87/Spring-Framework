package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Java implements Course {

    @Autowired  // if no annotations it takes automatically take it as a DI
    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }
    // Also it can work with Lombok annotation @Autowired
    private ExtraSessions extraSessions;
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Java hours "+(30+extraSessions.gethours()));
    }


}
