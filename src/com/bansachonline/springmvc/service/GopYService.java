package com.bansachonline.springmvc.service;

import com.bansachonline.springmvc.dao.GopYImpl;
import com.bansachonline.springmvc.model.GopY;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by DELL on 05/25/2018.
 */
public class GopYService {
    @Autowired
    GopYImpl gopYDao;
    public  int add(GopY a)
    {
        return gopYDao.Add(a);
    }
    public List<GopY> ShowAll()
    {
        return gopYDao.FindAll();
    }
}
