package com.bansachonline.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bansachonline.springmvc.interfacedao.SachDao;
import com.bansachonline.springmvc.model.Sach;

@Repository
public class SachImpl extends AbstractImpl<Integer,Sach> implements SachDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Sach> ShowInforSach(int size, int begin) {
		List<Sach> resulta= new ArrayList<Sach>();
		List<Sach> result= new ArrayList<Sach>();
		Session ss= sessionFactory.getCurrentSession();
		Query sql=ss.createQuery("FROM Sach");
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
