package com.newad.realestate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newad.realestate.dao.AdminDao;
import com.newad.realestate.dao.RoleDao;
import com.newad.realestate.model.Role;
import com.newad.realestate.model.User;
import com.newad.realestate.security.NewadUserDetails;

@Service
@Transactional(readOnly = true)
public class NewadUserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private AdminDao adminDao;
    
    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String account)
            throws UsernameNotFoundException {
        boolean user_exists = true;
        User user = adminDao.findByAccount(account);
        
        if(user == null) user_exists = false;
            
        if(!user_exists)
            throw new UsernameNotFoundException("User " + account + " does not exist.");
        
        Set<Role> roles = user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        return new NewadUserDetails
                .Builder(user.getAccount(), user.getPassword())
                .authorities(authorities)
                .build();
    }

}
