package com.bansachonline.springmvc.interfacedao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable,T>  {
	List<T> FindAll();
	int Update(T enTity);
	Object[] FinbyProperty(String property, Object value, String typesort, String sortdicrection);
	int DeleteT(T enTity);
	int Add(T enTiTy);
}
