package com.bansachonline.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansachonline.springmvc.dao.SachImpl;
import com.bansachonline.springmvc.model.Sach;
@Service
public class SachService {
	@Autowired
	SachImpl sAchdAo;
	public int Add(Sach a){return  sAchdAo.Add(a);}
	public List<Sach> ShowBookLimit(int size, int begin){
		return sAchdAo.ShowInforSach(size, begin);
	} 
	public List<Sach> ShowAll(){
		return sAchdAo.FindAll();
	}
	public int DeleteSach(Sach a)
	{
		return sAchdAo.DeleteT(a);
	}
	public int UpdateInfor(Sach a)
	{
		return sAchdAo.Update(a);
	}
	public  Object[] FindbyProperty(String thuoctinh, Object giatri, String kieusapxep, String chieusapxep )
	{
		return sAchdAo.FinbyProperty(thuoctinh, giatri, kieusapxep, chieusapxep);
	}
}
