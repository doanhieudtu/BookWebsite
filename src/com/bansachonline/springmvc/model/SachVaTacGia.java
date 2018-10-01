package com.bansachonline.springmvc.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SachVaTacGia")
public class SachVaTacGia {
	@Id
	@Column(name="MaCt")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaCt;

	@ManyToOne
	@JoinColumn(name="MaTG")
	TacGia tAgIa;

	@ManyToOne
	@JoinColumn(name="MaSach")
	Sach sAchtAcgIa;

	@Column(name="VaiTro")
	private String VaiTro;

	@Column(name="ViTri")
	private String ViTri;

	public int getMaCt() {
		return MaCt;
	}
	public void setMaCt(int maCt) {
		MaCt = maCt;
	}
	public TacGia gettAgIa() {
		return tAgIa;
	}
	public void settAgIa(TacGia tAgIa) {
		this.tAgIa = tAgIa;
	}
	public Sach getsAchtAcgIa() {
		return sAchtAcgIa;
	}
	public void setsAchtAcgIa(Sach sAchtAcgIa) {
		this.sAchtAcgIa = sAchtAcgIa;
	}
	public String getVaiTro() {
		return VaiTro;
	}
	public void setVaiTro(String vaiTro) {
		VaiTro = vaiTro;
	}
	public String getViTri() {
		return ViTri;
	}
	public void setViTri(String viTri) {
		ViTri = viTri;
	}
	
}
