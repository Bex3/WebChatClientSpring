package com.example;
//html  client

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bearden-tellez on 9/24/16.
 */

@RestController
public class ChatJsonController {

    @Autowired
    MessageRepository messages;

    WebChatClient myClient = new WebChatClient();

    @RequestMapping(path= "/getMessages.json", method = RequestMethod.GET)
//    public String message(String message) throws Exception {
    public ArrayList<Message> messages(User user, String message) throws Exception {
        ArrayList<Message> messageList = new ArrayList<Message>();
//        Iterable<Message> allMessages = messages.findAll(); // hibernate (object relational mapping) uses the repo

//            String serverResponse = myClient.SendMessage(message);
//            System.out.println(serverResponse);
//            Message thisMessage = new Message(user, message);
//            messages.save(thisMessage);
            Iterable<Message> allMessages = messages.findAll();

            for (Message currentMessage : allMessages) {
                messageList.add(currentMessage);
            }

        return messageList;
    }

    @RequestMapping(path= "/inputMessage.json", method = RequestMethod.POST)
    public ArrayList<String> sendUserMessage(HttpSession session, @RequestBody Message message) {
        ArrayList<String> totalMessages = new ArrayList<>();
//        String serverResponse = null; //take this out maybe??
        User user = (User)session.getAttribute("user");
//        Message newMessage = new Message (user, message.messageText);
        message.user = user;
        messages.save(message);

        return totalMessages;
    }

}
