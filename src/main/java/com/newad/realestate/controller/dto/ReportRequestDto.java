package com.newad.realestate.controller.dto;

import java.util.Map;

public class ReportRequestDto {
    
    String name, email, tel, need;
    
    Map<String, Boolean> reports;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public Map<String, Boolean> getReports() {
        return reports;
    }

    public void setReports(Map<String, Boolean> reports) {
        this.reports = reports;
    }

}
