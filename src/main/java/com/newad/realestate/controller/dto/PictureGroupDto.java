package com.newad.realestate.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.newad.realestate.model.Picture;
import com.newad.realestate.model.PictureGroup;

public class PictureGroupDto {
    
    private long id;
    private List<PictureDto> pictures;
    
    public PictureGroupDto() {}
    
    public PictureGroupDto(PictureGroup group) {
        this.id = group.getId();
        List<PictureDto> dtos = new ArrayList<>();
        for(Picture p : group.getPictures()) {
            PictureDto dto = new PictureDto(p);
            dtos.add(dto);
        }
        this.pictures = dtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PictureDto> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureDto> pictures) {
        this.pictures = pictures;
    }

}
