package com.newad.realestate.service.impl;

import java.io.IOException;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.newad.realestate.dao.PictureDao;
import com.newad.realestate.dao.PictureGroupDao;
import com.newad.realestate.model.Picture;
import com.newad.realestate.model.PictureGroup;
import com.newad.realestate.service.AdminPictureService;
import com.newad.realestate.util.FileUtil;

@Service
@Transactional(readOnly = true)
public class AdminPictureServiceImpl implements AdminPictureService {
    
    @Autowired
    private ServletContext servletContext;
    @Resource
    private PictureGroupDao picGroupDao;
    @Resource
    private PictureDao picDao;
    
    private final String DATA_PATH = "OPENSHIFT_DATA_DIR";
    private String REAL_PATH;
    
    @PostConstruct
    public void init() {
        this.REAL_PATH = System.getenv(DATA_PATH) + "/property_images";
    }

    @Override
    @Transactional(readOnly = false)
    public boolean savePicture(long picGroupId, MultipartFile file) {
        PictureGroup group = picGroupDao.get(picGroupId);
        
        String file_name = String.valueOf(Calendar.getInstance().getTimeInMillis());
        String ext_name = FilenameUtils.getExtension(file.getOriginalFilename());
        if(ext_name.equals("")) ext_name = "jpg";
        
        boolean success = true;
        
        try {
            /* save file to hard disk */
            FileUtil.createFile(REAL_PATH+ "/" + file_name+ "." +ext_name,
                    file.getBytes());
            
            /* write db record */
            Picture p = Picture.getInstance(group, 0, 0,
                    REAL_PATH+ "/" +file_name+ "." +ext_name);
            picDao.create(p);
        } catch(IOException e) {
            /* bad things happened! */
            success = false;
            e.printStackTrace();
        }
        
        return success;
    }

    @Override
    @Transactional(readOnly = false)
    public void deletePicture(long id) {
        picDao.deleteById(id);
    }

    @Override
    public Picture getPictureById(Long id) {
        return picDao.get(id);
    }

}
