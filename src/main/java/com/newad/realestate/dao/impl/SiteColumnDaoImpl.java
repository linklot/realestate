package com.newad.realestate.dao.impl;

import org.springframework.stereotype.Repository;

import com.newad.realestate.dao.SiteColumnDao;
import com.newad.realestate.model.SiteColumn;

@Repository
public class SiteColumnDaoImpl extends AbstractHbnDao<SiteColumn> implements
        SiteColumnDao {

    @Override
    public SiteColumn getRootColumnWithFullColumnTree() {
        return (SiteColumn) super
                    .getSession()
                    .getNamedQuery("SiteColumn.findRootColumn")
                    .list()
                    .get(0);
    }

}
