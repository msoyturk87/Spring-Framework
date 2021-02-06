package com.cybertek.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


        public AuthenticationManager authenticationManagerBean() throws Exception{

            return super.authenticationManagerBean();
        }

        protected  void configure(HttpSecurity http) throws Exception{

            http
                    .csrf()
                    .disable()
                    .authorizeRequests()
                    .antMatchers("/authenticate")
                    .permitAll()
                    .anyRequest()
                    .authenticated();
                    // they are disable this one from real
        }












}
