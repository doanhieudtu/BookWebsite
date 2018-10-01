package com.bansachonline.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bansachonline.springmvc.interfacedao.KhachHangDao;
import com.bansachonline.springmvc.model.DonHang;
import com.bansachonline.springmvc.model.KhachHang;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class KhacHangImpl extends AbstractImpl<Integer, KhachHang> implements KhachHangDao{
//	@Autowired
//	SessionFactory sessionFactory;
//
	@Override
	@Transactional
	public KhachHang DangNhap(String email, String matkhau) {
		KhachHang khachHang= new KhachHang();
		khachHang= null;
		org.hibernate.Session ss= sessionFactory.getCurrentSession();
		StringBuilder hQl= new StringBuilder("FROM KhachHang WHERE( Email");
		hQl.append(" = :Email");
		hQl.append(" AND MatKhau");
		hQl.append(" = :MatKhau )");
		javax.persistence.Query query= ss.createQuery(hQl.toString());
		query.setParameter("Email",email);
		query.setParameter("MatKhau", matkhau);
		try {
			khachHang=(KhachHang)query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Not found Entity !!!");
		}
	return khachHang;
	}
	
	
	@Override
	@Transactional
	public List<DonHang> getDonHangLazy(KhachHang a, int begin, int size) {
		List<DonHang> result = null;
		org.hibernate.Session ss= sessionFactory.openSession();
		KhachHang khacHang=(KhachHang)ss.get(KhachHang.class,a.getMaKH());
		result= khacHang.getdOnhAng();
		double Maxsize= result.size();
		List<DonHang> ls= new ArrayList<>();
		if(begin==0)
		{	
			for(int i=0;i<Maxsize;i++)
			{
				ls.add(result.get(i));
			}
		}
		else
		{
			if(Maxsize-begin<5)
			{
				System.out.println(begin);
				for(int i=begin;i<Maxsize;i++)
				{
					ls.add(result.get(i));
				}
			}
			else
			for(int i=begin;i<begin+size;i++)
			{
				
				ls.add(result.get(i));
			}
		}
		ss.close();
		return ls;
	}
}
