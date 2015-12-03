package com.martinetherton.twilio.server;

import com.twilio.sdk.verbs.TwiMLException;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by martin on 02/12/15.
 */
public class TwimlResponseBuilderTest {


    @Test
    public void testBuilder() throws TwiMLException {
        TwimlResponseBuilder twimlResponseBuilder = new TwimlResponseBuilder();
        Assert.assertThat(twimlResponseBuilder.toXml(),is("<Response><Gather numDigits=\"1\" action=\"enqueue_call\" timeout=\"5\"><Say language=\"es\">Para Espanol oprime el uno.</Say><Say language=\"en\">For English please hold or press two.</Say></Gather></Response>"));
    }

}
