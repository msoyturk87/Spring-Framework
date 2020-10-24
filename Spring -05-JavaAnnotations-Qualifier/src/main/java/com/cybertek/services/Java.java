package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    /*
    OPTION 1 with field
    @Autowired
    @Qualifier("mockInterviewHours")
    */

    private ExtraSessions extraSessions;

   //  OPTION 2 with Constructor
    public Java(@Qualifier("officeHours") ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Java hours "+(30+extraSessions.gethours()));
    }


}
