package com.bansachonline.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.dao.ChuDeImpl;
import com.bansachonline.springmvc.model.ChuDe;

@Service
public class ChuDeService {
	@Autowired
	ChuDeImpl cHudE;
	
	public List<ChuDe> ShowAll(){
		return cHudE.FindAll();
	}
	public int add(ChuDe a){return cHudE.Add(a);}
	public int DeleteChuDe(ChuDe a)
	{
		return cHudE.DeleteT(a);
	}
	public int UpdateInfor(ChuDe a)
	{
		return cHudE.Update(a);
	}
	public  Object[] FindbyProperty(String thuoctinh, Object giatri, String kieusapxep, String chieusapxep )
	{
		return cHudE.FinbyProperty(thuoctinh, giatri, kieusapxep, chieusapxep);
	}
}
