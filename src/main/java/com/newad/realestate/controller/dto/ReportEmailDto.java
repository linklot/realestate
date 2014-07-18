package com.newad.realestate.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReportEmailDto {
    
    private final String name;
    private final String email;
    private final List<String> reports;
    
    public ReportEmailDto(String name, String email, Map<String, Boolean> request) {
        this.name = name;
        this.email = email;
        
        this.reports = new ArrayList<>();
        Set<String> keys = request.keySet();
        for(String key : keys) {
            if(request.get(key)) {
                reports.add(key);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getReports() {
        return reports;
    }

}
