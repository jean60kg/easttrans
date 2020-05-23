package com.ecloud.service.impl;

import com.ecloud.dao.UserDao;
import com.ecloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2020/5/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;//注入UserDao

    @Override
    public int queryCount() {
        return userDao.queryCount();
    }

}
