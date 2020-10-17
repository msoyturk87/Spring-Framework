package service;

import implementation.Mentor;

import java.util.function.DoubleToIntFunction;

public class FullTimeMentor implements Mentor {
    @Override
    public void createAccount() {
        System.out.println("Full Time Mentor Account is created... ");    }
}
