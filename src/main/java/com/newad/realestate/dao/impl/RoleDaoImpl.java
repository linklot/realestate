package com.newad.realestate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.newad.realestate.dao.RoleDao;
import com.newad.realestate.model.Role;

@Repository
public class RoleDaoImpl extends AbstractHbnDao<Role> implements RoleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findByUserId(long id) {
        List<Role> roles = super.getSession()
            .getNamedQuery("Role.findRolesByUserId")
            .setLong("id", id)
            .list();
        return roles;
    }

}
