package com.newad.realestate.controller.dto;

import com.newad.realestate.model.Picture;

public class PictureDto {
    
    private long id;
    private int width, height;
    private String path;
    
    public PictureDto() {}
    
    public PictureDto(Picture picture) {
        this.id = picture.getId();
        this.width = picture.getWidth();
        this.height = picture.getHeight();
        this.path = picture.getPath();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
