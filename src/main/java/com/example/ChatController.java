package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

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
    public String login(HttpSession session, String userName, String password) throws Exception {
        User user = users.findFirstByName(userName);
        if (user == null) {
            user = new User(userName, password);
            users.save(user);
        } else if (!password.equals(user.getPassword())) {
            throw new Exception("Incorrect password");
        }
        session.setAttribute("user", user);
        return "home";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/addmessages", method = RequestMethod.POST)
    public String addTheMessage(HttpSession session, String messageText) {
        User user = (User) session.getAttribute("user");
        Message thisMessage = new Message(user, messageText);
        System.out.println("My runtime repo: " + thisMessage.toString());
        messages.save(thisMessage); //uses the repo to save it
        return "redirect:/";
    }

}