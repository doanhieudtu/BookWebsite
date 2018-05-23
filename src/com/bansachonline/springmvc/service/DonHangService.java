package com.bansachonline.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.dao.DonHangImpl;
import com.bansachonline.springmvc.model.DonHang;
@Service
public class DonHangService {
	@Autowired
	DonHangImpl dOnhAng;

	public int AddDonHang(DonHang a)
	{
		return dOnhAng.Add(a);
	}
	
	public List<DonHang> ShowAll(){
		return dOnhAng.FindAll();
	}
	
	public int DeleteDonHang(DonHang a)
	{
		return dOnhAng.DeleteT(a);
	}
	public int UpdateInfor(DonHang a)
	{
		return dOnhAng.Update(a);
	}
	public  Object[] FindbyProperty(String thuoctinh, Object giatri, String kieusapxep, String chieusapxep )
	{
		return dOnhAng.FinbyProperty(thuoctinh, giatri, kieusapxep, chieusapxep);
	}
}
