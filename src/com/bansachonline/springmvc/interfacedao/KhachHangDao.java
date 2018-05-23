package com.bansachonline.springmvc.interfacedao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.bansachonline.springmvc.model.DonHang;
import com.bansachonline.springmvc.model.KhachHang;

@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public interface KhachHangDao extends GenericDao<Integer, KhachHang>{
	KhachHang DangNhap(String email, String matkhau);
	List<DonHang> getDonHangLazy(KhachHang a, int begin, int size);
}
