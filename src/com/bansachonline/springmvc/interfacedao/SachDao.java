package com.bansachonline.springmvc.interfacedao;

import java.util.List;

import com.bansachonline.springmvc.model.Sach;

public interface SachDao extends GenericDao<Integer,Sach>{
	List<Sach> ShowInforSach(int size, int begin);
}
