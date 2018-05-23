package com.bansachonline.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ChiTietDonHang")
public class ChiTietDonHang {
	@Id
	@Column(name="MaCTDH")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaCTDH;

	@ManyToOne()
	@JoinColumn(name="MaSach")
	Sach sAchdOnhAng;
	@ManyToOne()
	@JoinColumn(name="MaDH")
	DonHang dOnhAng;
	@Column(name="SoLuong")
	private int SoLuong;
	@Column(name="DonGia")
	private float DonGia;
	public Sach getsAchdOnhAng() {
		return sAchdOnhAng;
	}
	public void setsAchdOnhAng(Sach sAchdOnhAng) {
		this.sAchdOnhAng = sAchdOnhAng;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getMaCTDH() {
		return MaCTDH;
	}
	public void setMaCTDH(int maCTDH) {
		MaCTDH = maCTDH;
	}
	public DonHang getdOnhAng() {
		return dOnhAng;
	}
	public void setdOnhAng(DonHang dOnhAng) {
		this.dOnhAng = dOnhAng;
	}
	public float getDonGia() {
		return DonGia;
	}
	public void setDonGia(float donGia) {
		DonGia = donGia;
	}
	
}
