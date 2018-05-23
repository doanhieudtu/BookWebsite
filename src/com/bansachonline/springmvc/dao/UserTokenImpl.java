package com.bansachonline.springmvc.dao;

import com.bansachonline.springmvc.interfacedao.UserTokenDao;
import com.bansachonline.springmvc.model.UserToken;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 05/22/2018.
 */
@Repository
public class UserTokenImpl extends  AbstractImpl<Integer,UserToken> implements UserTokenDao {
}
