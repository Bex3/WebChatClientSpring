package com.example;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ArrayList<Message> messages(String message) throws Exception {
        ArrayList<Message> messageList = new ArrayList<Message>();
//        Iterable<Message> allMessages = messages.findAll(); // hibernate (object relational mapping) uses the repo

        try{
            String serverResponse = myClient.SendMessage(message);
            System.out.println(serverResponse);
            Message thisMessage = new Message(message);
            messages.save(thisMessage);
            Iterable<Message> allMessages = messages.findAll();

            for (Message currentMessage : allMessages) {
                messageList.add(currentMessage);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Returning Message");
        return messageList;
    }

    @RequestMapping(path= "/sendMessage.json", method = RequestMethod.GET)
    public ArrayList<String> sendUserMessage(String messageText) {
        ArrayList<String> totalMessages = new ArrayList<>();
        String serverResponse = null;
        try{
            Message newMessage = new Message (messageText);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return totalMessages;
    }

}
