package com.example.websocketdemo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.websocketdemo.model.Greeting;
import com.example.websocketdemo.model.HelloMessage;

/**In Spring’s approach to working with STOMP messaging, STOMP messages can be routed to
 * @Controller classes.
*/

@Controller
public class GreetingController {

    @MessageMapping("/hello")   //will receive messages on this topic
    @SendTo("/topic/greetings") //will send messages to client on this topic
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
