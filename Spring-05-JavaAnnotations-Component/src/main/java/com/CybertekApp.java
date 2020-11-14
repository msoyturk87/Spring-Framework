package com;

import com.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        ApplicationContext container=new ClassPathXmlApplicationContext("config.xml");
        Course course=(Course)container.getBean("selenium");
        // Class name is first char is Capital  we can pass it as a lowercase situation

        Course course1=(Course)container.getBean("API");
        // Class name is all CAPITAL we can pass it as a CAPITAL

        course.getTeachingHours();
        course1.getTeachingHours();

    }
}
