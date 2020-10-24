package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {


    /* 1- CONSTRUCTOR INJ
    @Autowired  // if no annotations it takes automatically take it as a DI
    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }
    // Also it can work with Lombok annotation @Autowired
    */

    // 2-SETTER INJ
    /*
    @Autowired
    public void setExtraSessions(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }
    */
    // 3- FIELD INJ
    @Autowired
    private ExtraSessions extraSessions;

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Java hours "+(30+extraSessions.gethours()));
    }


}
