package com.bansachonline.springmvc.test;

import com.bansachonline.springmvc.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.dao.SachImpl;
import com.bansachonline.springmvc.interfacedao.SachDao;
import com.bansachonline.springmvc.model.Sach;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class test {

	@Autowired
	static  MailService mail;

	public static void main(String[] args) {
		mail.sendMail("nhasachcdio397@gmail.com","doanhieudtu@gmail.com","Hello Im CDIO 397","test");
	}

}
