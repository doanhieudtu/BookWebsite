package com.bansachonline.springmvc.model;

import org.hibernate.annotations.Type;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NhaXuatBan")
public class NhaXuatBan {
	@Id
	@Column(name="MaNXB")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaNXB;
	@Column(name="TenNXB")
	private String TenNXB;
	@Column(name="DiaChi")
	private String DiaChi;
	@Column(name="DienThoai")
	private String DienThoai;
	@OneToMany(mappedBy="nHaxUatbAn",fetch=FetchType.LAZY)
	List<Sach> lIstsAch;
	public int getMaNXB() {
		return MaNXB;
	}
	public void setMaNXB(int maNXB) {
		MaNXB = maNXB;
	}
	public String getTenNXB() {
		return TenNXB;
	}
	public void setTenNXB(String tenNXB) {
		TenNXB = tenNXB;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getDienThoai() {
		return DienThoai;
	}
	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}
	
}
