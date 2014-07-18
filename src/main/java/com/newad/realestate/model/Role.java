package com.newad.realestate.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@NamedQueries({
//    @NamedQuery(name="Role.findRolesByUserId",
//                query="select r from Role r join r.users rusers where rusers.id = :id")
    @NamedQuery(name="Role.findRolesByUserId",
    query="from Role r")
  })
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private long id;
    
    @Column(name = "ROLE_NAME")
    private String name;
    
    @ManyToMany(mappedBy="roles")
    private Set<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
