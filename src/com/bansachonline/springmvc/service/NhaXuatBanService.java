package com.bansachonline.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.dao.NhaXuatBanImpl;
import com.bansachonline.springmvc.model.NhaXuatBan;
@Service
public class NhaXuatBanService {
	@Autowired
	NhaXuatBanImpl NXBdAo;
	
	public List<NhaXuatBan> ShowAll(){
		return NXBdAo.FindAll();
	}
	public int add(NhaXuatBan a){return  NXBdAo.Add(a);}
	public int DeleteNhaXuatBan(NhaXuatBan a)
	{
		return NXBdAo.DeleteT(a);
	}
	public int UpdateInfor(NhaXuatBan a)
	{
		return NXBdAo.Update(a);
	}
	public  Object[] FindbyProperty(String thuoctinh, Object giatri, String kieusapxep, String chieusapxep )
	{
		return NXBdAo.FinbyProperty(thuoctinh, giatri, kieusapxep, chieusapxep);
	}
}
