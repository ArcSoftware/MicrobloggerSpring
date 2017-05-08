package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
public class MicroBlogSpringController {
    public static ArrayList<Message> messages = new ArrayList<>();


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", messages);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String message(HttpSession session, Message text) {
        session.setAttribute("message", text);
        messages.add(text);
        System.out.println(text.id + text.messageText);

        return "redirect:/";
    }
    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(HttpSession session, String id) {
//        Message a = messages.get(id);
        messages.remove(messages.get(Integer.valueOf(id)));
        System.out.println(id);
        return "redirect:/";
    }
}
