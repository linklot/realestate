package com.newad.realestate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.newad.realestate.dao.ReportRequestDao;
import com.newad.realestate.model.ReportRequest;

@Repository
public class ReportRequestDaoImpl extends AbstractHbnDao<ReportRequest>
        implements ReportRequestDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<ReportRequest> getAllInOrder() {
        return super.getSession()
                .getNamedQuery("ReportRequest.findAll").list();
    }

}
