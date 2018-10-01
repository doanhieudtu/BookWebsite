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
@Table(name="TacGia")
public class TacGia {
	@Id
	@Column(name="MaTG")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaTG;

	@Column(name="TenTG")
	private String TenTG;

	@Column(name="DiaChi")
	private String DiaChi;

	@Column(name="DienThoai")
	private String DienThoai;
	@OneToMany(mappedBy="tAgIa", fetch=FetchType.LAZY)
	List<SachVaTacGia> lIssAch;

	public List<SachVaTacGia> getlIssAch() {
		return lIssAch;
	}
	public void setlIssAch(List<SachVaTacGia> lIssAch) {
		this.lIssAch = lIssAch;
	}
	public String getDienThoai() {
		return DienThoai;
	}
	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}
	public int getMaTG() {
		return MaTG;
	}
	public void setMaTG(int maTG) {
		MaTG = maTG;
	}
	public String getTenTG() {
		return TenTG;
	}
	public void setTenTG(String tenTG) {
		TenTG = tenTG;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	

}
