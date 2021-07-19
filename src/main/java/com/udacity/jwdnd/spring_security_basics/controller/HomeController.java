package com.udacity.jwdnd.spring_security_basics.controller;

import com.udacity.jwdnd.spring_security_basics.model.Message;
import com.udacity.jwdnd.spring_security_basics.model.MessageForm;
import com.udacity.jwdnd.spring_security_basics.service.MessageListService;
import com.udacity.jwdnd.spring_security_basics.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    //private MessageListService messageListService;
    private MessageService messageService;
    private String username;
    private Message message;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
        this.message = new Message();
        username = "ay haga";
    }

    /*
    @ResponseBody
    public String getCurrentUserName(Authentication authentication) {
        this.username = authentication.getName();
        return username;
    }
    */
    @GetMapping()
    public String getHomePage(MessageForm messageForm, Model model) {
        model.addAttribute("greetings", messageService.getAllMessages());
        //model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping()
    public String addMessage(MessageForm messageForm, Model model,Authentication authentication ) {

        this.username = authentication.getName();

        message.setusername(username);
        message.setMessagetext(messageForm.getText());

        messageService.addMessage(message);
        //messageListService.addMessage(messageForm.getText());

        model.addAttribute("greetings", messageService.getAllMessages());
        //model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
}
