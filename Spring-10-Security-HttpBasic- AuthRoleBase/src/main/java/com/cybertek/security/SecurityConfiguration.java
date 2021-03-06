package com.cybertek.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { // To overwrite Security part extends WebSecurityConfigurerAdapter
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()          // request should be authorized
        .antMatchers("index.html").permitAll()         //  Everybody can see this page even without credentials
        .antMatchers("/profile/**").authenticated()    //  Everybody can see this DIRECTORY with credentials
        .antMatchers("/admin/**").hasRole("ADMIN")     //  Only ADMIN can see ADMIN DIRECTORY  -- hasAuthority("ROLE_ADMIN") Second Way
        .antMatchers("/management/**").hasAnyRole("ADMIN","MANAGER")   // Only ADMIN and MANAGER can see MANAGEMENT DIRECTORY
        .and()
        .httpBasic(); // perform basic http authentication
       }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("88888888")).roles("ADMIN")
                .and()
                .withUser("mehmet").password(passwordEncoder().encode("88888888")).roles("USER")
                .and()
                .withUser("manager").password(passwordEncoder().encode("88888888")).roles("MANAGER");


    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
