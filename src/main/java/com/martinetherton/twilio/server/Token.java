package com.martinetherton.twilio.server;

import javax.xml.bind.annotation.*;

/**
 * Created by martin on 13/01/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "token", namespace = "http://www.springsource.com/token")
public class Token {

    @XmlAttribute
    protected String workerToken;

    public Token() {}

    public Token(String workerToken) {
        this.workerToken = workerToken;
    }

    public void setWorkerToken(String workerToken) {
        this.workerToken = workerToken;
    }

    public String getWorkerToken() {
        return workerToken;
    }
}
