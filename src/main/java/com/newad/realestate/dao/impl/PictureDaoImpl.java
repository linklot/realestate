package com.newad.realestate.dao.impl;

import org.springframework.stereotype.Repository;

import com.newad.realestate.dao.PictureDao;
import com.newad.realestate.model.Picture;

@Repository
public class PictureDaoImpl extends AbstractHbnDao<Picture> implements
        PictureDao {

}
