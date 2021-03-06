package com.bansachonline.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bansachonline.springmvc.model.ChuDe;
import com.bansachonline.springmvc.model.NhaXuatBan;
import com.bansachonline.springmvc.model.Sach;
import com.bansachonline.springmvc.model.SachVaTacGia;
import com.bansachonline.springmvc.model.TacGia;
import com.bansachonline.springmvc.service.ChuDeService;
import com.bansachonline.springmvc.service.NhaXuatBanService;
import com.bansachonline.springmvc.service.SachService;
import com.bansachonline.springmvc.service.SachVaTacGiaService;
import com.bansachonline.springmvc.service.TacGiaService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/san-pham/")
public class SanPhamController {
	
	@Autowired
	NhaXuatBanService NXBsErvice;
	
	@Autowired
	ChuDeService cHudEsEvice;
	@Autowired
	TacGiaService tacgiaService;
	
	@Autowired
	SachVaTacGiaService sachVaTacGia;

	@Autowired
  	SachService sachService;
	@RequestMapping("them")
	public String ThemSanPham(ModelMap mm)
	{
		try {
			Sach SACH= new Sach();
			SACH=sachService.ShowAll().get(0);
			ArrayList<SachVaTacGia> lsTacGiaVaSach= new ArrayList<>();
			ArrayList<TacGia> lsTacGia= new ArrayList<>();

			lsTacGiaVaSach= (ArrayList<SachVaTacGia>) sachVaTacGia.FindbyProperty("MaSach",SACH.getMaSach(),"MaSach","DESC")[0];

			for(SachVaTacGia a: lsTacGiaVaSach) lsTacGia.add(a.gettAgIa());
			mm.addAttribute("Sach",SACH);
			mm.addAttribute("NhaXB", SACH.getnHaxUatbAn().getTenNXB());
			mm.addAttribute("tacGia", lsTacGia);
			List<Sach> lsSach=null;
			lsSach= sachService.ShowBookLimit(5,0);
			double tongPageSach= Math.ceil((double)sachService.ShowAll().size()/5);
			mm.put("TongPageSach", tongPageSach);
			mm.put("ListSach", lsSach);
			mm.put("ChuDe", (List<ChuDe>)cHudEsEvice.ShowAll());
			mm.put("NhaXuatBan", (List<NhaXuatBan>)NXBsErvice.ShowAll());
			mm.put("TacGia", tacgiaService.ShowAll());
			return "them-san-pham";
		}catch (Exception ae){}
		return "them-san-pham";
	}
	@GetMapping
	@RequestMapping("chu-de")
	public String SachTheoChuDe(@RequestParam int MaCD, ModelMap mm){
		try {
			ArrayList<Sach> lsSach= new ArrayList<>();
			ArrayList<ChuDe> lsChuDe= new ArrayList<>();
			lsChuDe=(ArrayList<ChuDe>) cHudEsEvice.FindbyProperty("MaCD",MaCD,"MaCD","DESC")[0];
			lsSach= (ArrayList<Sach>) sachService.FindbyProperty("MaCD",MaCD,"MaCD","DESC")[0];
			mm.put("ListSach",lsSach);
			mm.put("ChuDe",lsChuDe.get(0).getTenCD());
			mm.put("lsChuDe",cHudEsEvice.ShowAll() );
		}catch (Exception e){}
		return "sach-theo-chu-de";
	}

}
