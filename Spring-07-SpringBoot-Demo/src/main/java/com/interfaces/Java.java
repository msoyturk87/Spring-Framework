package com.interfaces;

import com.services.Course;
import com.services.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    private ExtraSessions extraSessions;

    @Value("${instructor}")
    private String instructorName;

    @Override
    public int getTeachingHours() {
        return 20+extraSessions.getHours();
    }
    @Autowired  // optional defauşt also gives same result
    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }
}
