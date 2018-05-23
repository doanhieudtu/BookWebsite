package com.bansachonline.springmvc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.model.GioHang;
import com.bansachonline.springmvc.model.ItemGioHang;
import com.bansachonline.springmvc.model.Sach;

@Service
public class XuLyGioHangSerVice {
	
	@Autowired
	SachService sachDao;
	
	public boolean KiemTraGioHang(int MaSach, GioHang listGioHang)
	{
		try {
			 ArrayList<ItemGioHang> lsItem= new ArrayList<>();
			 lsItem= listGioHang.getDanhSachSP();
			 for(ItemGioHang a: lsItem) if(a.getMaSanPham()==MaSach) return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public boolean ThemSoLuong(int MaSach, ItemGioHang gioHang,int soluong)
	{
		ArrayList<Sach> sach= (ArrayList<Sach>) sachDao.FinbyProperty("MaSach",MaSach,"MaSach", "DESC")[0];
		if(gioHang.getSoLuong()>sach.get(0).getSoLuongTon()) return false;
		else
		{
			gioHang.setSoLuong(gioHang.getSoLuong()+soluong);
		}
		return true;
	}
	public boolean GiamSoLuong(int MaSach,ItemGioHang gioHang,int soluong)
	{
		ArrayList<Sach> sach= (ArrayList<Sach>) sachDao.FinbyProperty("MaSach",MaSach,"MaSach", "DESC")[0];
		if(gioHang.getSoLuong()>sach.get(0).getSoLuongTon()) return false;
		else
		{
			gioHang.setSoLuong(gioHang.getSoLuong()-soluong);
		}
		return true;
	}
	public float TongTien(GioHang gioHang)
	{

			float tongTien=0;
			int soluong=0;
			for(ItemGioHang a: gioHang.getDanhSachSP())
			{
				tongTien+= a.getGiaBan()*a.getSoLuong();
				soluong+= a.getSoLuong();
			}
			gioHang.setTongSoLuong(soluong);
			gioHang.setTongTien(tongTien);
			
			return tongTien;
	}
	public void ThemItem(ItemGioHang a, GioHang gioHang)
	{
		ArrayList<ItemGioHang> lsItem=new ArrayList<>();
		try {
			lsItem=gioHang.getDanhSachSP();
		} catch (Exception e) {
			// TODO: handle exception
		}
		lsItem.add(a);
		gioHang.setDanhSachSP(lsItem);
	}
}
