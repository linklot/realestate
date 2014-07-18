package com.newad.realestate.dao;

import com.newad.realestate.model.SiteColumn;

public interface SiteColumnDao extends Dao<SiteColumn> {
    
    SiteColumn getRootColumnWithFullColumnTree();

}
