package com.martinetherton.twilio.server;

import com.twilio.sdk.verbs.TwiMLException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

//    @RequestMapping(path="incoming_call",method=RequestMethod.GET, produces="application/xml")
    @RequestMapping(path="incoming_call",method=RequestMethod.GET)
    public @ResponseBody String incomingCall() throws IOException, TwiMLException {
        return twimlResponseBuilder.incomingCall();
    }

    @RequestMapping(path="enqueue_call",method=RequestMethod.POST)
    public @ResponseBody String enqueueCall() throws IOException, TwiMLException {
        return twimlResponseBuilder.enqueueCall();
    }

    @RequestMapping(path="assignment_callback.json",method=RequestMethod.POST)
    public @ResponseBody String assignments() throws IOException, TwiMLException {
        final Map<String, String> dequeueInstruction = new HashMap<String, String>();
        dequeueInstruction.put("instruction", "dequeue");
        dequeueInstruction.put("from", "+31858889347");
        dequeueInstruction.put("post_work_activity_sid", "WAc8db9ecd2be972674749569394841e54");
        return JSONObject.toJSONString(dequeueInstruction);
    }

}
