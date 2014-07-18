package com.newad.realestate.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "PICTUREGROUP")
public class PictureGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PICTUREGROUP_ID")
    private long id;
    
    @Column(name = "TIME_CREATED")
    private Calendar timeCreated;
    
    @OneToMany(mappedBy = "pictureGroup", cascade = CascadeType.REMOVE)
    @OrderBy("id")
    private Set<Picture> pictures;
    
    public PictureGroup() {}
    
    private PictureGroup(Calendar timeCreated) {
        this.id = 0l;
        this.timeCreated = timeCreated;
        this.pictures = new HashSet<>();
    }
    
    public static PictureGroup getInstance() {
        return new PictureGroup(Calendar.getInstance());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Calendar timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

}
