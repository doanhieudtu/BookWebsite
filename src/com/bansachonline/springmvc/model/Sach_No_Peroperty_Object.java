package com.bansachonline.springmvc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Sach_No_Peroperty_Object {
	
		private String TenSach;
	
		private float GiaBan;
	
		private String MoTa;

		private String AnhBia;
		
		@DateTimeFormat(iso=ISO.DATE)
		private Date NgayCapNhat;
		
		private String TacGia;
		
		public String getTacGia() {
			return TacGia;
		}

		public void setTacGia(String tacGia) {
			TacGia = tacGia;
		}

		private int SoLuongTon; 

		private String MaChuDe;
	
		private String MaNXB;

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

		public String getMaChuDe() {
			return MaChuDe;
		}

		public void setMaChuDe(String maChuDe) {
			MaChuDe = maChuDe;
		}

		public String getMaNXB() {
			return MaNXB;
		}

		public void setMaNXB(String maNXB) {
			MaNXB = maNXB;
		}
		
}

