package com.martinetherton.twilio.server;

import com.twilio.sdk.verbs.*;

/**
 * Created by martin on 02/12/15.
 */
public class TwimlResponseBuilder {


    public String toXml() throws TwiMLException {
        final TwiMLResponse twiml = new TwiMLResponse();
        final Gather gather = new Gather();
        gather.setNumDigits(1);
        gather.setTimeout(5);
        gather.setAction("enqueue_call");

        final Say sayEspanol = new Say("Para Espanol oprime el uno.");
        sayEspanol.setLanguage("es");

        final Say sayEnglish = new Say("For English stroke american please hold or press two.");
        sayEnglish.setLanguage("en");

        try {
            gather.append(sayEspanol);
            gather.append(sayEnglish);
            twiml.append(gather);
        } catch (final TwiMLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return twiml.toXML();
    }

    public String toEnqueueXml() {
        final TwiMLResponse twiml = new TwiMLResponse();
        final Enqueue enqueue = new Enqueue();
        enqueue.setWorkflowSid("WW50d2a142e9a85d125c49d3bd8789a9da");

        final com.twilio.sdk.verbs.Task task = new com.twilio.sdk.verbs.Task("{\"selected_language\":\"es\"}");

        try {
            enqueue.append(task);
            twiml.append(enqueue);
        } catch (final TwiMLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return twiml.toXML();
    }
}
