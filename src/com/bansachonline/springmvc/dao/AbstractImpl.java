package com.bansachonline.springmvc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bansachonline.springmvc.interfacedao.GenericDao;
@Repository
public abstract class AbstractImpl<ID extends Serializable,T> implements GenericDao<ID, T> {
	
	private Class<T> persistenceClass;

	public Class<T> getPersistenceClass() {
		return persistenceClass;
	}

	public void setPersistenceClass(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}
	@SuppressWarnings("unchecked")
	public AbstractImpl() {
//		this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		Type genericSuperClass = getClass().getGenericSuperclass();

		ParameterizedType parametrizedType = null;
		while (parametrizedType == null) {
		   if ((genericSuperClass instanceof ParameterizedType)) {
		       parametrizedType = (ParameterizedType) genericSuperClass;
		   } else {
		       genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
		   }
		}

		this.persistenceClass = (Class<T>) parametrizedType.getActualTypeArguments()[1];
	}
	private String getNamepersistence() {
		return this.persistenceClass.getSimpleName();
	}
	
	@Autowired
	SessionFactory sessionFactory;
	
	 
	@Transactional
	@Override
	public int Add(T enTiTy) {
		int sTatus=0;
		Session ss= sessionFactory.getCurrentSession();
		try {
			ss.persist(enTiTy);
			sTatus=1;
		} catch (Exception e) {
		}
		return sTatus;
	}
	
	@Transactional
	@Override
	public int DeleteT(T enTity) {
		int sTatus=0;
		Session ss= sessionFactory.getCurrentSession();
		try {
			ss.delete(enTity);
			sTatus=1;
		} catch (Exception e) {
		}
		return sTatus;
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Object[] FinbyProperty(String property, Object value, String typesort, String sortdicrection) {
		Session ss= sessionFactory.getCurrentSession();
		List<T> lIst= new ArrayList<T>();
		try {
			StringBuilder hQl= new StringBuilder("FROM ");
			hQl.append(getNamepersistence());
			hQl.append(" WHERE ");
			if(property!=null && value!=null)
			{
				hQl.append(property);
				hQl.append(" = :Value");
			}
			if(typesort!=null && sortdicrection!=null)
			{
				hQl.append(" ORDER BY ");
				hQl.append(typesort);
				hQl.append(" "+sortdicrection);
			}
			Query qUery= ss.createQuery(hQl.toString());
			qUery.setParameter("Value", value);
			lIst= qUery.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Object[]{lIst};
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<T> FindAll() {
		List<T> lIst=null;
		Session ss= sessionFactory.getCurrentSession();
		try {
			StringBuilder hQl= new StringBuilder("FROM ");
			hQl.append(getNamepersistence());
			Query query= ss.createQuery(hQl.toString());
			lIst= query.getResultList();
		} catch (Exception e) {
		}
		return lIst;
	}
	
	@Transactional
	@Override
	public int Update(T enTity) {
		Session ss= sessionFactory.getCurrentSession();
		int sTatus=0;
		try {
			ss.saveOrUpdate(enTity);
			sTatus=1;
		} catch (Exception e) {
		}
		
		return sTatus;
	}
	
}
