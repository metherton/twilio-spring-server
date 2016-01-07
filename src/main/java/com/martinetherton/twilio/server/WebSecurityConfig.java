package com.martinetherton.twilio.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Created by martin on 06/12/15.
 */
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity) throws Exception
    {
        webSecurity
                .ignoring()
                // All of Spring Security will ignore the requests
                .antMatchers(HttpMethod.POST, "/assignment_callback.json")
        ;

        webSecurity
                .ignoring()
                // All of Spring Security will ignore the requests
                .antMatchers(HttpMethod.POST, "/enqueue_call")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/incoming_call").permitAll()
                .anyRequest().authenticated();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }

}
