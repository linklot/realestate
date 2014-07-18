package com.newad.realestate.model;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.newad.realestate.util.EnvUtil;

@Entity
@Table(name = "REPORTREQUEST")
@NamedQueries({
    @NamedQuery(name="ReportRequest.findAll",
                query="from ReportRequest r order by r.id desc")
})
public class ReportRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REPORTREQUEST_ID")
    private long id;
    
    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "NEED")
    private String need;
    
    @Column(name = "TIME")
    private Calendar time;
    
    @Column(name = "REPORTS")
    private String reports;
    
    public ReportRequest() {}
    
    public ReportRequest(String name, String email, String tel, String need,
            Map<String, Boolean> reports) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.need = need;
        this.time = Calendar.getInstance();
        
        Set<String> keys = reports.keySet();
        StringBuilder sb = new StringBuilder();
        for(String key : keys) {
            if(reports.get(key)) {
                switch(key) {
                case "gfzn":
                    sb.append("澳洲购房指南");
                    break;
                case "tzym":
                    sb.append("商业投资移民签证简介");
                    break;
                case "jsym":
                    sb.append("独立技术移民简介");
                    break;
                case "gzdb":
                    sb.append("雇主担保移民简介");
                    break;
                case "dxlx":
                    sb.append("大学生留学方案");
                    break;
                case "zxlx":
                    sb.append("中学生留学方案");
                    break;
                default:
                    break;
                }
            }
            sb.append("，");
        }
        if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        this.reports = sb.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
    
    public String getReadableTime() {
        return EnvUtil.formatCalendarShort(this.time);
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

}
