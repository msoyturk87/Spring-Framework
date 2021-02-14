package com.cybertek.interfaces;

import com.cybertek.services.ExtraSessions;
import org.springframework.stereotype.Component;

@Component
public class OfficeHours implements ExtraSessions {



    @Override
    public int getHours() {
        return 4;
    }
}
