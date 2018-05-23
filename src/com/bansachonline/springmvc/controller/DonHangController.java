package com.bansachonline.springmvc.controller;

import com.bansachonline.springmvc.model.DonHang;
import com.bansachonline.springmvc.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/don-hang/")
public class DonHangController {
	@Autowired
	DonHangService donHangService;

	@RequestMapping("")
	public String HoaDon(ModelMap mm)
	{
		try {
			List<DonHang> donHangAll=new ArrayList<>();
			donHangAll=donHangService.ShowAll();
			List<DonHang> donHangTheoNgay= new ArrayList<>();
			Date date= new Date();
			SimpleDateFormat dfs= new SimpleDateFormat("yyy-MM-dd");
			donHangTheoNgay= (ArrayList<DonHang>)donHangService.FindbyProperty("NgayDat",dfs.parse(dfs.format(date)),"MaDH","DESC")[0];
			mm.put("DonHangAll",donHangAll);
			mm.put("DonHangTheoNgay", donHangTheoNgay);
		}catch (Exception e){}

		return "hoadon";
	}
	

}
