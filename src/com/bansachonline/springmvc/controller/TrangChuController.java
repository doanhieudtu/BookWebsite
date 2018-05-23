package com.bansachonline.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bansachonline.springmvc.model.KhachHang;
import com.bansachonline.springmvc.model.Sach;
import com.bansachonline.springmvc.service.SachService;

@Controller
@SessionAttributes({"User","GioHang"})
@RequestMapping("/cdio/")
public class TrangChuController {
	@Autowired
	SachService sachService;
	
	@RequestMapping("trangchu")
	public String TrangChu(ModelMap mm, HttpSession ss) {
		List<Sach> ls=sachService.ShowInforSach(16,0);
		KhachHang khacHang= new KhachHang();
		try {
			khacHang=(KhachHang)ss.getAttribute("User");
		} catch (Exception e) {
			// TODO: handle exception
		}
		mm.addAttribute("ListSach", ls);
		if(khacHang!=null)
		{
			return "trangchu";
		}
		else
		{
			KhachHang khachHang= new KhachHang();
			khachHang.setEmail("chuadangnhap");
			mm.addAttribute("User",khachHang);
		}
		return "trangchu";
	}
}
