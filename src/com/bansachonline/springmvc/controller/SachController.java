package com.bansachonline.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bansachonline.springmvc.model.ChuDe;
import com.bansachonline.springmvc.model.NhaXuatBan;
import com.bansachonline.springmvc.model.Sach;
import com.bansachonline.springmvc.model.Sach_No_Peroperty_Object;
import com.bansachonline.springmvc.service.ChuDeService;
import com.bansachonline.springmvc.service.NhaXuatBanService;
import com.bansachonline.springmvc.service.SachService;

@Controller
@RequestMapping("/Sach/")
public class SachController {
	@Autowired
	SachService sAchsErvice;
	
	@Autowired
	NhaXuatBanService NXBsErvice;
	
	@Autowired
	ChuDeService cHudEsEvice;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("them")
	public String ThemSach(@ModelAttribute("Sach") Sach_No_Peroperty_Object sAch,Model mm )
	{
		@SuppressWarnings("unchecked")
		List<ChuDe> lsCd= (List<ChuDe>)cHudEsEvice.FindbyProperty("MaCD",Integer.parseInt(sAch.getMaChuDe()),"MaCD","DESC")[0];
		List<NhaXuatBan> lsNXB= (List<NhaXuatBan>) NXBsErvice.FindbyProperty("MaNXB",Integer.parseInt(sAch.getMaNXB()),"MaNXB","DESC")[0];
		Sach sach= new Sach();
		sach.setAnhBia(sAch.getAnhBia());
		sach.setTenSach(sAch.getTenSach());
		sach.setGiaBan(sAch.getGiaBan());
		sach.setMoTa(sAch.getMoTa());
		sach.setNgayCapNhat(sAch.getNgayCapNhat());
		sach.setSoLuongTon(sAch.getSoLuongTon());
		sach.setnHaxUatbAn(lsNXB.get(0));
		sach.setcHudE(lsCd.get(0));
		sAchsErvice.Add(sach);
		mm.addAttribute("SachOb",sach);
		return "trangchu";
	}
}
