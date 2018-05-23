package com.bansachonline.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.dao.ChiTietDonHangImpl;
import com.bansachonline.springmvc.model.ChiTietDonHang;
@Service
public class ChiTietDonHangService {
	@Autowired
	ChiTietDonHangImpl dEtaildAo;
	public int addCTDonHang(ChiTietDonHang a)
	{
		return dEtaildAo.Add(a);
	}
	public List<ChiTietDonHang> ShowAll(){
		return dEtaildAo.FindAll();
	}
	
	public int DeleteChiTietDonHang(ChiTietDonHang a)
	{
		return dEtaildAo.DeleteT(a);
	}
	public int UpdateInfor(ChiTietDonHang a)
	{
		return dEtaildAo.Update(a);
	}
	public  Object[] FindbyProperty(String thuoctinh, Object giatri, String kieusapxep, String chieusapxep )
	{
		return dEtaildAo.FinbyProperty(thuoctinh, giatri, kieusapxep, chieusapxep);
	}
}
