package com.cybertek.interfaces;

import com.cybertek.services.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    @Override
    public int getTeachingHours() {
        return 20;
    }
}
