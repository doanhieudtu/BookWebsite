package com.bansachonline.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.dao.SachVaTacGiaImpl;
import com.bansachonline.springmvc.model.SachVaTacGia;
@Service
public class SachVaTacGiaService {
	@Autowired
	SachVaTacGiaImpl sAchVStAcgIadAO;
	
	public  int Add(SachVaTacGia a)
	{
		return sAchVStAcgIadAO.Add(a);
				
	}
	public List<SachVaTacGia> ShowAll(){
		return sAchVStAcgIadAO.FindAll();
	}
	
	public int DeleteSachVSTacGia(SachVaTacGia a)
	{
		return sAchVStAcgIadAO.DeleteT(a);
	}
	public int UpdateInfor(SachVaTacGia a)
	{
		return sAchVStAcgIadAO.Update(a);
	}
	public  Object[] FindbyProperty(String thuoctinh, Object giatri, String kieusapxep, String chieusapxep )
	{
		return sAchVStAcgIadAO.FinbyProperty(thuoctinh, giatri, kieusapxep, chieusapxep);
	}
}
