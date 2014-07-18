package com.newad.realestate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "SITECOLUMN")
@NamedQueries({
////    @NamedQuery(name="Role.findRolesByUserId",
////                query="select r from Role r join r.users rusers where rusers.id = :id")
    @NamedQuery(name="SiteColumn.findRootColumn",
    query="from SiteColumn c where c.id=1")
  })
public class SiteColumn {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SITECOLUMN_ID")
    private long id;
    
    @Column(name = "NAME")
    private String name;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PARENT_ID")
    private SiteColumn parent;
    
    @OneToMany(mappedBy="parent", cascade = CascadeType.REMOVE)
    @OrderBy("id")
    private Set<SiteColumn> children;
    
    @OneToMany(mappedBy="column")
    @OrderBy("id desc")
    private Set<SiteTopic> topics;
    
    public SiteColumn() {}
    
    public SiteColumn(SiteColumn parentColumn, String columnName ) {
        this.id = 0;
        this.name = columnName.trim();
        this.parent = parentColumn;
        this.children = new HashSet<>();
        this.topics = new HashSet<>();
    }

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

    public SiteColumn getParent() {
        return parent;
    }

    public void setParent(SiteColumn parent) {
        this.parent = parent;
    }

    public Set<SiteColumn> getChildren() {
        return children;
    }

    public void setChildren(Set<SiteColumn> children) {
        this.children = children;
    }

}
