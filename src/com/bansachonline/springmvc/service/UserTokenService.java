package com.bansachonline.springmvc.service;

import com.bansachonline.springmvc.dao.UserTokenImpl;
import com.bansachonline.springmvc.model.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DELL on 05/22/2018.
 */
@Service
public class UserTokenService  {

    @Autowired
    UserTokenImpl userToken;

    public int Add(UserToken a){
        return  userToken.Add(a);
    }
}
