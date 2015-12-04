package com.martinetherton.twilio.server;

import com.twilio.sdk.verbs.Gather;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
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

//    @RequestMapping("/")
//    public Map<String,Object> home() {
//        Map<String,Object> model = new HashMap<String,Object>();
//        model.put("id", UUID.randomUUID().toString());
//        model.put("content", "Hello World");
//        return model;
//    }
//
//    @RequestMapping(path="/incoming_call", method=RequestMethod.GET)
//    public @ResponseBody TwiMLResponse routeCall(HttpServletRequest request, HttpServletResponse response) {
//
//        TwiMLResponse twiml = new TwiMLResponse();
//        final Gather gather = new Gather();
//        gather.setNumDigits(1);
//        gather.setTimeout(5);
//        gather.setAction("enqueue_call");
//
//        final Say sayEspanol = new Say("Para Espanol oprime el uno.");
//        sayEspanol.setLanguage("es");
//
//        final Say sayEnglish = new Say("For English, please hold or press two.");
//        sayEnglish.setLanguage("en");
//
//        try {
//            gather.append(sayEspanol);
//            gather.append(sayEnglish);
//            twiml.append(gather);
//        } catch (final TwiMLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return twiml;
//    }

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

}
