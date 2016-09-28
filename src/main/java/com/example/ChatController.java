package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by bearden-tellez on 9/24/16.
 */

@Controller
public class ChatController {
    @Autowired
    MessageRepository messages;

    @Autowired
    UserRepository users;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model, String userName, String text) throws Exception {
//        User user = users.findFirstByName(userName);
//        if (user == null) {
//            user = new User(userName);
//            users.save(user);
//
//        }
//        session.setAttribute("user", user);
//        return "home";
//    }

    if (session.getAttribute("user") != null) {
        model.addAttribute("user", session.getAttribute("user"));
    }

    ArrayList<Message> messageList = new ArrayList<>();
        if (users != null){
        User savedUser = (User)session.getAttribute("user");
        if (savedUser != null) {
            messageList = messages.findByUser(savedUser);
        } else {
            Iterable<Message> allMessages = messages.findAll();
            for (Message message : allMessages) {
                messageList.add(message);
            }
        }
    }
        model.addAttribute("message", messageList);
        return "home";
}
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) throws Exception {
        User user = users.findFirstByName(userName);
        if (user == null) {
            user = new User(userName);
            users.save(user);
//        } else if (!password.equals(user.getPassword())) {
//            throw new Exception("Incorrect password");
        }
        session.setAttribute("user", user);
        return "redirect:/chat";
    }

    @RequestMapping(path = "/chat", method = RequestMethod.GET)
    public String chat() {
        return "chat";
    }

    @RequestMapping(path = "/sendMessage", method = RequestMethod.POST)
    public String inputText(HttpSession session, String message) {
        WebChatClient myChatClient = new WebChatClient();
        User user = (User)session.getAttribute("user");
        myChatClient.SendMessage(message);
//        session.getAttribute(message);
        Message newMessage = new Message(user, message);

//        message.user = user;
        messages.save(newMessage);

        System.out.println("message added to session");
        return "redirect:/chat";
    }

}