package com.newad.realestate.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.newad.realestate.model.Property;
import com.newad.realestate.model.SiteColumn;
import com.newad.realestate.model.SiteTopic;

public class IndexPageDto {
    
    private List<IndexPropertyDto> propertyDtos;
    private IndexColumnDto column_zxdt;//最新动态
    private IndexColumnDto column_zcfg;//政策法规
    private IndexColumnDto column_tzzn;//投资指南
    private IndexColumnDto column_gfxz;//购房须知
    
    private IndexPageDto() {
        propertyDtos = new ArrayList<>();
    }
    
    public IndexPageDto(List<Property> properties,
            SiteColumn c_zxdt, SiteColumn c_zcfg,
            SiteColumn c_tzzn, SiteColumn c_gfxz,
            List<SiteTopic> t_zxdt, List<SiteTopic> t_zcfg,
            List<SiteTopic> t_tzzn, List<SiteTopic> t_gfxz) {
        
        this();
        
        for(Property p : properties) {
            IndexPropertyDto dto = new IndexPropertyDto(p);
            propertyDtos.add(dto);
        }
        
        column_zxdt = new IndexColumnDto(c_zxdt, t_zxdt);
        column_zcfg = new IndexColumnDto(c_zcfg, t_zcfg);
        column_tzzn = new IndexColumnDto(c_tzzn, t_tzzn);
        column_gfxz = new IndexColumnDto(c_gfxz, t_gfxz);
    }

    public List<IndexPropertyDto> getPropertyDtos() {
        return propertyDtos;
    }

    public IndexColumnDto getColumn_zxdt() {
        return column_zxdt;
    }

    public IndexColumnDto getColumn_zcfg() {
        return column_zcfg;
    }

    public IndexColumnDto getColumn_tzzn() {
        return column_tzzn;
    }

    public IndexColumnDto getColumn_gfxz() {
        return column_gfxz;
    }

}
