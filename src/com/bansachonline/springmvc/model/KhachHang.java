package com.bansachonline.springmvc.model;

import org.hibernate.annotations.Type;

import java.util.Date;
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
@Table(name="KhachHang")
public class KhachHang {
	@Id
	@Column(name="MaKH")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaKH; 
	@Column(name="TenTK")
	private String TenTK;
	@Column(name="HoTen")
	private String HoTen;
	@Column(name="DienThoai")
	private String DienThoai;
	@Column(name="GioiTinh")
	private byte GioiTinh;
	@Column(name="NgaySinh")
	private Date NgaySinh;
	@Column(name="Email")
	private String Email;
	@Column(name="MatKhau")
	private String MatKhau;
	@Column(name="DiaChi")
	private String DiaChi;

	@OneToMany(mappedBy = "UserToken", fetch =FetchType.LAZY)
	List<UserToken> lsUserToken;

	@OneToMany(mappedBy="kHachhAng", fetch=FetchType.LAZY)
	 List<DonHang> dOnhAng;
	
	public List<DonHang> getdOnhAng() {
		return dOnhAng;
	}
	public void setdOnhAng(List<DonHang> dOnhAng) {
		this.dOnhAng = dOnhAng;
	}
	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public String getTenTK() {
		return TenTK;
	}
	public void setTenTK(String tenTK) {
		TenTK = tenTK;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getDienThoai() {
		return DienThoai;
	}
	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}
	public byte getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(byte gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
}
