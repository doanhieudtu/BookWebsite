package com.bansachonline.springmvc.model;

import java.util.ArrayList;

public class GioHang {
	private ArrayList<ItemGioHang> danhSachSP;
	private float tongTien;
	private int tongSoLuong;
	public int getTongSoLuong() {
		return tongSoLuong;
	}
	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}
	public ArrayList<ItemGioHang> getDanhSachSP() {
		return danhSachSP;
	}
	public void setDanhSachSP(ArrayList<ItemGioHang> danhSachSP) {
		this.danhSachSP = danhSachSP;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	
}
