package com.newad.realestate.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
@PrimaryKeyJoinColumn(name = "USER_ID")
@NamedQueries({
    @NamedQuery(name="Admin.findByAccount",
                query="from Admin a where a.account = :account")
  })
public class Admin extends User {

}
