package services;

import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        BeanFactory container=new ClassPathXmlApplicationContext("config.xml");
        //ApplicationContext container=new ClassPathXmlApplicationContext("config.xml");

        //Way 1
        Mentor mentor=(Mentor)container.getBean("fullTimeMentor");
        mentor.createAccount();
        //Way 2
        Mentor mentors=(Mentor)container.getBean("partTimeMentor");
        mentors.createAccount();
        // Way  3
        Mentor m=container.getBean("fullTimeMentor",Mentor.class);
        m.createAccount();

        Mentor m1=container.getBean("partTimeMentor",Mentor.class);
        m.createAccount();

    }
}
