package com;

import com.configs.CybertekAppConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        ApplicationContext container=new AnnotationConfigApplicationContext(CybertekAppConfig.class);
        Course course=(Course)container.getBean("java");
        course.getTeachingHours();

        ((AnnotationConfigApplicationContext)container).close();

        System.out.println(course.toString());


    }
}
