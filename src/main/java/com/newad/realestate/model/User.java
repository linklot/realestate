package com.newad.realestate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;
    
    @Column(name = "ACCOUNT")
    private String account;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "USER_ROLE",
            joinColumns = { @JoinColumn(name="FK_USER_ID") },
            inverseJoinColumns = { @JoinColumn(name="FK_ROLE_ID") })
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof User))return false;
        return this.getAccount().equals(((User)other).getAccount());
    }

    @Override
    public int hashCode() {
        return account.hashCode();
    }
    
    public User() {}
    
    public User(String account, String password) {
        this.id = Long.valueOf(0l);
        this.account = account;
        this.password = password;
        this.roles = new HashSet<Role>();
    }

}
