package com.martinetherton.twilio.server;

import com.twilio.sdk.CapabilityToken;
import com.twilio.sdk.taskrouter.TaskRouterWorkerCapability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martin on 13/01/16.
 */
@RestController
public class TokenController {

    private TaskRouterWorkerCapability taskRouterWorkerCapability;

    @Autowired
    public TokenController(TaskRouterWorkerCapability taskRouterWorkerCapability) {
        this.taskRouterWorkerCapability = taskRouterWorkerCapability;
    }

    @RequestMapping(path="agents", method=RequestMethod.GET)
    public Token token() {
        taskRouterWorkerCapability.allowActivityUpdates();
        taskRouterWorkerCapability.allowReservationUpdates();
        String token = null;
        try {
            token = taskRouterWorkerCapability.generateToken();
        } catch (CapabilityToken.DomainException e) {
            e.printStackTrace();
        }
        return new Token(token);
    }
}
