package com.martinetherton.twilio.server;

import com.twilio.sdk.verbs.TwiMLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by martin on 02/12/15.
 */
@RestController
public class TaskRouterController {




    private TwimlResponseBuilder twimlResponseBuilder;

    @Autowired
    public TaskRouterController(TwimlResponseBuilder twimlResponseBuilder) {
        this.twimlResponseBuilder = twimlResponseBuilder;
    }

    @RequestMapping(path="incoming_call",method=RequestMethod.GET)
    public String incomingCall() throws IOException, TwiMLException {
        return twimlResponseBuilder.toXml();
    }

}