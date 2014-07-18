package com.newad.realestate.dao.impl;

import org.springframework.stereotype.Repository;

import com.newad.realestate.dao.AdminDao;
import com.newad.realestate.model.Admin;

@Repository
public class AdminDaoImpl extends AbstractHbnDao<Admin>
    implements AdminDao {

    @Override
    public Admin findByAccount(String account) {
        account = account.toLowerCase();
        account = account.trim();
        return (Admin) super.getSession()
            .getNamedQuery("Admin.findByAccount")
            .setString("account", account)
            .uniqueResult();
    }

}
