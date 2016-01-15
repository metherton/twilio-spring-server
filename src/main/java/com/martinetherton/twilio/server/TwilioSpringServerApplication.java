package com.martinetherton.twilio.server;

import com.twilio.sdk.taskrouter.TaskRouterWorkerCapability;
import com.twilio.sdk.verbs.Gather;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
@EnableRedisHttpSession
public class TwilioSpringServerApplication extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_XML);
    }

    public static void main(String[] args) {
        SpringApplication.run(TwilioSpringServerApplication.class, args);
    }

//    @Bean
//    HeaderHttpSessionStrategy sessionStrategy() {
//        return new HeaderHttpSessionStrategy();
//    }

    @Bean
    TwimlResponseBuilder twimlResponseBuilder() {
        return new TwimlResponseBuilder();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    TaskRouterWorkerCapability taskRouterWorkerCapability() {
        return new TaskRouterWorkerCapability("ACcfe5e87f30326045cdde74d99bfcccf2", "0ce5c20a765ced1f3b2f5b84fbb0f809", "WS2b332a2b43dc7e9e6570b7ac423afcf6", "WK4bff31efe22e92409c4fa7728b7c76a3");
    }

}
