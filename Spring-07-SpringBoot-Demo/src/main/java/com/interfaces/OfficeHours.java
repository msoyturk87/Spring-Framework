package com.interfaces;

import com.services.ExtraSessions;
import org.springframework.stereotype.Component;

@Component
public class OfficeHours implements ExtraSessions {


    @Override
    public int getHours() {
        return 4;
    }
}
