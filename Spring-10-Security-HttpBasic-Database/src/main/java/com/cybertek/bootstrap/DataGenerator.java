package com.cybertek.bootstrap;

import com.cybertek.entity.User;
import com.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DataGenerator(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void run(String... args) throws Exception{


        //Delete All
        this.userRepository.deleteAll();

        //Create users
        User employee=new User("ozzy", passwordEncoder.encode("ozzy123"),"USER","");
        User admin=new User("admin",passwordEncoder.encode("ozzy123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager=new User("manager",passwordEncoder.encode("ozzy123"),"MANAGER","ACCESS_TEST1");

        List<User> users= Arrays.asList(employee,admin,manager);
        userRepository.saveAll(users);

    }

    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
}
