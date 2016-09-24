package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by bearden-tellez on 9/24/16.
 */

@RestController
public class ChatJsonController {

    @Autowired
    MessageRepository messages;

    @RequestMapping(path= "/message.json", method = RequestMethod.GET)
    public Message messages(String message) throws Exception {
        ArrayList<Message> messageList = new ArrayList<Message>();
        Iterable<Message> allMessages = messages.findAll(); // hibernate (object relational mapping) uses the repo
        for (Message currentMessage : allMessages) {
            messageList.add(currentMessage);
        }

        System.out.println("Returning Message");
        return messageList;
    }
}
