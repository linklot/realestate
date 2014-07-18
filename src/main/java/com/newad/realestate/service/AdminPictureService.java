package com.newad.realestate.service;

import org.springframework.web.multipart.MultipartFile;

import com.newad.realestate.model.Picture;

public interface AdminPictureService {
    
    boolean savePicture(long picGroupId, MultipartFile file);
    
    void deletePicture(long id);
    
    Picture getPictureById(Long id);

}
