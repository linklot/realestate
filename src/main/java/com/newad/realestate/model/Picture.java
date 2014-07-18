package com.newad.realestate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PICTURE")
public class Picture {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PICTURE_ID")
    private long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PICTUREGROUP_ID")
    private PictureGroup pictureGroup;
    
    @Column(name = "WIDTH")
    private int width;
    
    @Column(name = "HEIGHT")
    private int height;
    
    @Column(name = "PATH")
    private String path;
    
    public Picture() {}
    
    private Picture(PictureGroup pictureGroup,
            int width, int height, String path) {
        this.id = 0l;
        this.pictureGroup = pictureGroup;
        this.width = width;
        this.height = height;
        this.path = path;
    }
    
    public static Picture getInstance(PictureGroup group,
            int width, int height, String path) {
        return new Picture(group, width, height, path);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PictureGroup getPictureGroup() {
        return pictureGroup;
    }

    public void setPictureGroup(PictureGroup pictureGroup) {
        this.pictureGroup = pictureGroup;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
