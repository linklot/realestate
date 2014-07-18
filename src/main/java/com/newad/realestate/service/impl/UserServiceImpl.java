package com.newad.realestate.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newad.realestate.dao.AdminDao;
import com.newad.realestate.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    
    @Resource
    private AdminDao adminDao;

    @Override
    public void findUsers() {
        long count = adminDao.count();
        System.out.println("total: " + count);
    }

}
