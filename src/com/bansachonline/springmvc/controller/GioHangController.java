package com.bansachonline.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bansachonline.springmvc.model.GioHang;

@SessionAttributes({"User","GioHang"})
@Controller
@RequestMapping("/GioHang")
public class GioHangController {
	@RequestMapping("/")
	public String GioHang(HttpSession ss, ModelMap mm) {
		GioHang gioHang= new GioHang();
		try {
			gioHang= (GioHang) ss.getAttribute("GioHang");
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(gioHang==null){
			return "redirect:/cdio/trangchu";
		}
		else
		{
			mm.put("GioHang", gioHang);
		}
		return "gio-hang";
	}
}
