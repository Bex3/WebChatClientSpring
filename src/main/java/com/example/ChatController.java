package com.example;

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
    @RequestMapping(path="/", method= RequestMethod.GET)
    public String login(HttpSession session, Model model) throws Exception{
        return "home";
    }


}