package org.cba.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by noel on 1/2/22
 */
@Component
public class MessageReceiver {

    @JmsListener(destination = "messageQueue", containerFactory = "myFactory")
    public void receiveMessage(CustomMessage customMessage) {
        System.out.println("Received <" + customMessage.getTheMessage() + ">");
    }

}
