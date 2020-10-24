package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        ApplicationContext container=new ClassPathXmlApplicationContext("config.xml");
        Course course=(Course)container.getBean("java");
        // Class name is first char is Capital  we can pass it as a lowercase situation

        System.out.println(course.toString());

    }
}
