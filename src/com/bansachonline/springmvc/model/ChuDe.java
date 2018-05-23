package com.bansachonline.springmvc.model;

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
@Table(name="ChuDe")
public class ChuDe {
	@Id
	@Column(name="MaCD")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaCD;
	@Column(name="TenCD")
	private String TenCD;
	@OneToMany(mappedBy="cHudE",fetch=FetchType.LAZY)
	List<Sach> lStsAch;
	public int getMaCD() {
		return MaCD;
	}
	public void setMaCD(int maCD) {
		MaCD = maCD;
	}
	public String getTenCD() {
		return TenCD;
	}
	public void setTenCD(String tenCD) {
		TenCD = tenCD;
	}
	public List<Sach> getlStsAch() {
		return lStsAch;
	}
	public void setlStsAch(List<Sach> lStsAch) {
		this.lStsAch = lStsAch;
	}
	
}
