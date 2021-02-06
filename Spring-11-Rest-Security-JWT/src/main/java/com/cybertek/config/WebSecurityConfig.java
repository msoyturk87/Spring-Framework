package com.cybertek.config;

import com.cybertek.service.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


         @Autowired
        private SecurityFilter securityFilter;

       // This is for API
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

            http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        }

















}