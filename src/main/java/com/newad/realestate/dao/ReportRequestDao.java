package com.newad.realestate.dao;

import java.util.List;

import com.newad.realestate.model.ReportRequest;

public interface ReportRequestDao extends Dao<ReportRequest> {
    
    List<ReportRequest> getAllInOrder();

}
