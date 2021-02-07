package com.configs;


import com.cybertek.interfaces.ExtraSessions;
import com.cybertek.services.Java;
import com.cybertek.services.OfficeHours;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan("com.cybertek")
@PropertySource("classpath:application.properties")
public class CybertekAppConfig {




    @Bean  // we can use instead of this @Component over Java,Selenium Class
    public Java java(){
        return new Java(extraSessions());
    }
    @Bean
    public Selenium selenium(){
        return new Selenium();
    }


    @Bean
    public ExtraSessions extraSessions(){
        return new OfficeHours();
    }



}
