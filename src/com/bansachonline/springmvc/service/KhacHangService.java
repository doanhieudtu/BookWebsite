package com.bansachonline.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.dao.KhacHangImpl;
import com.bansachonline.springmvc.model.DonHang;
import com.bansachonline.springmvc.model.KhachHang;


@Service
public class KhacHangService {
	@Autowired
	KhacHangImpl kHachhAngdAo;
	public List<DonHang> getDonHangLazy(KhachHang a, int begin, int size)
	{
		return kHachhAngdAo.getDonHangLazy(a,begin,size);
	}
	public KhachHang DangNhap(String email, String matkhau)
	{
		return kHachhAngdAo.DangNhap(email, matkhau);
	}
	public List<KhachHang> ShowAll(){
		return kHachhAngdAo.FindAll();
	}
	public int ThemKhachHang(KhachHang a)
	{
		return kHachhAngdAo.Add(a);
	}
	public int DeleteKhacHang(KhachHang a)
	{
		return kHachhAngdAo.DeleteT(a);
	}
	public int UpdateInfor(KhachHang a)
	{
		return kHachhAngdAo.Update(a);
	}
	public  Object[] FindbyProperty(String thuoctinh, Object giatri, String kieusapxep, String chieusapxep )
	{
		return kHachhAngdAo.FinbyProperty(thuoctinh, giatri, kieusapxep, chieusapxep);
	}
}
