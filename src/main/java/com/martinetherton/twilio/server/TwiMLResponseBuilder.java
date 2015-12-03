package com.martinetherton.twilio.server;

import com.twilio.sdk.verbs.Gather;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

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

        final Say sayEnglish = new Say("For English, please hold or press two.");
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
}
