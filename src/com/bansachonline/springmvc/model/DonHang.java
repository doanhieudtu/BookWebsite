package com.bansachonline.springmvc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DonHang")
public class DonHang {
	@Id
	@Column(name="MaDH")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaDH;
	@Column(name="NgayDat")
	private Date NgayDat;
	@Column(name="NgayGiao")
	private Date NgayGiao;
	@Column(name="TinhTrangGiaoHang")
	private byte TinhTrangGiaoHang;
	@Column(name="DaThanhToan")
	private float DaThanhToan;
	@ManyToOne
	@JoinColumn(name="MaKH")
	KhachHang kHachhAng;
	@Column(name="GhiChu")
	private String ghiChu;
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public List<ChiTietDonHang> getcHitIetdOnhAng() {
		return cHitIetdOnhAng;
	}
	public void setcHitIetdOnhAng(List<ChiTietDonHang> cHitIetdOnhAng) {
		this.cHitIetdOnhAng = cHitIetdOnhAng;
	}
	@OneToMany(mappedBy="dOnhAng",fetch=FetchType.LAZY)
	List<ChiTietDonHang> cHitIetdOnhAng;
	public int getMaDH() {
		return MaDH;
	}
	public void setMaDH(int maDH) {
		MaDH = maDH;
	}
	public Date getNgayDat() {
		return NgayDat;
	}
	public void setNgayDat(Date ngayDat) {
		NgayDat = ngayDat;
	}
	public Date getNgayGiao() {
		return NgayGiao;
	}
	public void setNgayGiao(Date ngayGiao) {
		NgayGiao = ngayGiao;
	}
	public byte getTinhTrangGiaoHang() {
		return TinhTrangGiaoHang;
	}
	public void setTinhTrangGiaoHang(byte tinhTrangGiaoHang) {
		TinhTrangGiaoHang = tinhTrangGiaoHang;
	}
	public float getDaThanhToan() {
		return DaThanhToan;
	}
	public void setDaThanhToan(float daThanhToan) {
		DaThanhToan = daThanhToan;
	}
	public KhachHang getkHachhAng() {
		return kHachhAng;
	}
	public void setkHachhAng(KhachHang kHachhAng) {
		this.kHachhAng = kHachhAng;
	}
}
