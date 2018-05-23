package com.bansachonline.springmvc.model;

public class ItemGioHang {
	private int MaSanPham;
	private String TenSanPham;
	private int Maxsize;
	private int SoLuong;
	private float GiaBan;
	private String anhBia;
	public String getAnhBia() {
		return anhBia;
	}
	public void setAnhBia(String anhBia) {
		this.anhBia = anhBia;
	}
	public int getMaxsize() {
		return Maxsize;
	}
	public void setMaxsize(int maxsize) {
		Maxsize = maxsize;
	}
	public int getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public float getGiaBan() {
		return GiaBan;
	}
	public void setGiaBan(float giaBan) {
		GiaBan = giaBan;
	}
	
}
