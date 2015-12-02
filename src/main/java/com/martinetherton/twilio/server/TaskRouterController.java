package com.martinetherton.twilio.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martin on 02/12/15.
 */
@RestController
public class TaskRouterController {

    @RequestMapping(path="incoming_call",method=RequestMethod.GET)
    public void incomingCall() {
        System.out.println("in incoming call");

    }

}
