package com.bansachonline.springmvc.interfacedao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bansachonline.springmvc.model.DonHang;
@Repository
public interface DonHangDao extends GenericDao<Integer, DonHang>{
	List<DonHang> ShowInforDonHang(int size, int begin);
}
