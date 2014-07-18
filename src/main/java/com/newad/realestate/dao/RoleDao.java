package com.newad.realestate.dao;

import java.util.List;

import com.newad.realestate.model.Role;

public interface RoleDao extends Dao<Role> {
    
    List<Role> findByUserId(long id);

}
