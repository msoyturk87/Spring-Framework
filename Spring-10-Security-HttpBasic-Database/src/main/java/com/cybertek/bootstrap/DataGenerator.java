package com.cybertek.bootstrap;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataGenerator implements CommandLineRunner { // it will push data before everything "CommandLineRunner"

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DataGenerator(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception { //

        //Delete All
        this.userRepository.deleteAll();

        //Create users
        User employee = new User("user", passwordEncoder.encode("88888888"), "USER","");
        User admin = new User("admin", passwordEncoder.encode("88888888"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("88888888"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(employee,admin,manager);

        userRepository.saveAll(users);


    }


}