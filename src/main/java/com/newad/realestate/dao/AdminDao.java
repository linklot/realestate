package com.newad.realestate.dao;

import com.newad.realestate.model.Admin;

public interface AdminDao extends Dao<Admin> {
    
    Admin findByAccount(String account);

}
