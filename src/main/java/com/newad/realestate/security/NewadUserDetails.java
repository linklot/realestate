package com.newad.realestate.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class NewadUserDetails implements UserDetails {
    
    private static final long serialVersionUID = 1729285228856674478L;
    private final List<GrantedAuthority> authorities;
    private final String username, password;
    
    private NewadUserDetails(Builder builder) {
        username = builder.username;
        password = builder.password;
        authorities = builder.authorities;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public static class Builder {
        private final String username, password;
        private List<GrantedAuthority> authorities;
        
        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
            this.authorities = new ArrayList<>();
        }
        
        public Builder authorities(List<GrantedAuthority> authorities) {
            this.authorities.addAll(authorities);
            return this;
        }
        
        public NewadUserDetails build() {
            return new NewadUserDetails(this);
        }
        
    }

}
