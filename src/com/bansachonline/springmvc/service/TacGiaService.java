package com.bansachonline.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.dao.TacGiaImpl;
import com.bansachonline.springmvc.model.TacGia;
@Service
public class TacGiaService {
	@Autowired
	TacGiaImpl tAcgIadAo;
	
	public List<TacGia> ShowAll(){
		return tAcgIadAo.FindAll();
	}
	public int add(TacGia a){return tAcgIadAo.Add(a);}
	public int DeleteTacGia(TacGia a)
	{
		return tAcgIadAo.DeleteT(a);
	}
	public int UpdateInfor(TacGia a)
	{
		return tAcgIadAo.Update(a);
	}
	public  Object[] FindbyProperty(String thuoctinh, Object giatri, String kieusapxep, String chieusapxep )
	{
		return tAcgIadAo.FinbyProperty(thuoctinh, giatri, kieusapxep, chieusapxep);
	}
}
