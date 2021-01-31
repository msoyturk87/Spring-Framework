package com.configs;


import com.cybertek.services.Java;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan("com.cybertek")
public class CybertekAppConfig {



    @Bean  // we can use instead of this @Component over Java,Selenium Class
    public Java java(){
        return new Java();
    }
    @Bean
    public Selenium selenium(){
        return new Selenium();
    }







}
