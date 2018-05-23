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
@Table(name="Sach")
public class Sach {
	@Id
	@Column(name="MaSach")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaSach;
	@Column(name="TenSach")
	private String TenSach;
	@Column(name="GiaBan")
	private float GiaBan;
	@Column(name="MoTa")
	private String MoTa;
	@Column(name="AnhBia")
	private String AnhBia;
	@Column(name="NgayCapNhat")
	private Date NgayCapNhat;
	@Column(name="SoLuongTon")
	private int SoLuongTon; 
	@ManyToOne
	@JoinColumn(name="MaCD")
	ChuDe cHudE;
	@ManyToOne
	@JoinColumn(name="MaNXB")
	NhaXuatBan nHaxUatbAn;
	@OneToMany(mappedBy="sAchtAcgIa", fetch=FetchType.LAZY)
	List<SachVaTacGia>  sAchtAcgIa;
	@OneToMany(mappedBy="sAchdOnhAng",fetch=FetchType.LAZY)
	List<ChiTietDonHang> lStcHitIet;
	public ChuDe getcHudE() {
		return cHudE;
	}
	public void setcHudE(ChuDe cHudE) {
		this.cHudE = cHudE;
	}
	public NhaXuatBan getnHaxUatbAn() {
		return nHaxUatbAn;
	}
	public void setnHaxUatbAn(NhaXuatBan nHaxUatbAn) {
		this.nHaxUatbAn = nHaxUatbAn;
	}
	public List<SachVaTacGia> getsAchtAcgIa() {
		return sAchtAcgIa;
	}
	public void setsAchtAcgIa(List<SachVaTacGia> sAchtAcgIa) {
		this.sAchtAcgIa = sAchtAcgIa;
	}
	public List<ChiTietDonHang> getlStcHitIet() {
		return lStcHitIet;
	}
	public void setlStcHitIet(List<ChiTietDonHang> lStcHitIet) {
		this.lStcHitIet = lStcHitIet;
	}
	public int getMaSach() {
		return MaSach;
	}
	public void setMaSach(int maSach) {
		MaSach = maSach;
	}
	public String getTenSach() {
		return TenSach;
	}
	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}
	public float getGiaBan() {
		return GiaBan;
	}
	public void setGiaBan(float giaBan) {
		GiaBan = giaBan;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public String getAnhBia() {
		return AnhBia;
	}
	public void setAnhBia(String anhBia) {
		AnhBia = anhBia;
	}
	public Date getNgayCapNhat() {
		return NgayCapNhat;
	}
	public void setNgayCapNhat(Date ngayCapNhat) {
		NgayCapNhat = ngayCapNhat;
	}
	public int getSoLuongTon() {
		return SoLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		SoLuongTon = soLuongTon;
	}
	
}
