package com.bansachonline.springmvc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bansachonline.springmvc.model.Sach;
import com.bansachonline.springmvc.model.SachVaTacGia;
import com.bansachonline.springmvc.model.TacGia;
import com.bansachonline.springmvc.service.ChuDeService;
import com.bansachonline.springmvc.service.SachService;
import com.bansachonline.springmvc.service.SachVaTacGiaService;

@Controller
@SessionAttributes({"User","GioHang"})
@RequestMapping("/Chi-Tiet-San-Pham/")
public class ChiTietSanPhamController {
	@Autowired
	SachService sachService;
	
	
	@Autowired
	SachVaTacGiaService sachVaTacGia;
	
	@Autowired
	ChuDeService chuDeService;

	@GetMapping("Sach")
	public String ChiTietSach(@RequestParam String MaSach, ModelMap mm)
	{
		try {
			ArrayList<Sach> sach= new ArrayList<Sach>();
			sach= (ArrayList<Sach>)sachService.FinbyProperty("MaSach", Integer.parseInt(MaSach),"MaSach", "DESC")[0];

			ArrayList<SachVaTacGia> lsTacGiaVaSach= new ArrayList<>();
			ArrayList<TacGia> lsTacGia= new ArrayList<>();

			lsTacGiaVaSach= (ArrayList<SachVaTacGia>) sachVaTacGia.FindbyProperty("MaSach",Integer.parseInt(MaSach),"MaSach","DESC")[0];

			for(SachVaTacGia a: lsTacGiaVaSach) lsTacGia.add(a.gettAgIa());
			mm.addAttribute("Sach", sach.get(0));
			mm.addAttribute("NhaXuatBan", sach.get(0).getnHaxUatbAn().getTenNXB());
			mm.addAttribute("TacGiaChiTiet", lsTacGia);
			mm.addAttribute("ChuDe", chuDeService.ShowAll());
		}catch (Exception e){}
		return "chi-tiet-sach";
	}
}
