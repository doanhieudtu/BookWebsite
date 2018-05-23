package com.bansachonline.springmvc.controller;

import com.bansachonline.springmvc.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 05/21/2018.
 */
@Controller
@RequestMapping("/mail/")
public class MailController {
    @Autowired
    MailService mail;

    @RequestMapping("")
    public String SendMail()
    {
        mail.sendMail("nhasachcdio397@gmail.com","doanhieudtu@gmail.com","Hello Im CDIO 397","test");
        return "send-mail";
    }
}
