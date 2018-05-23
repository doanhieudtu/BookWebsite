package com.bansachonline.springmvc.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bansachonline.springmvc.interfacedao.DonHangDao;
import com.bansachonline.springmvc.model.DonHang;
@Repository
public class DonHangImpl extends AbstractImpl<Integer, DonHang> implements DonHangDao{

	@Override
	public List<DonHang> ShowInforDonHang(int size, int begin) {
		List<DonHang> resulta= new ArrayList<DonHang>();
		List<DonHang> result= new ArrayList<DonHang>();
		Session ss= sessionFactory.getCurrentSession();
		Query sql=ss.createQuery("FROM DonHang");
		resulta= sql.getResultList();
		double Maxsize= resulta.size();
		if(begin==0)
		{	
			for(int i=0;i<size;i++)
			{
				result.add(resulta.get(i));
			}
		}
		else
		{
			if(Maxsize-begin<5)
			{
				System.out.println(begin);
				for(int i=begin;i<Maxsize;i++)
				{
					result.add(resulta.get(i));
				}
			}
			else
			for(int i=begin;i<begin+size;i++)
			{
				
				result.add(resulta.get(i));
			}
		}
		return result;
	}
}
