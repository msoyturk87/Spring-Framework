package com;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {


        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course1 = (Course) container.getBean("java");
        course1.getTeachingHours();

        Course course2 = (Course) container.getBean("java");
        course2.getTeachingHours();

        System.out.println("Pointing same object "+(course1==course2));
        System.out.println(course1+" course 1");
        System.out.println(course2+" course 2");

        // Study about prototype and singleton change your scope="singleton">






    }

}
