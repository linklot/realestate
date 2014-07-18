package com.newad.realestate.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class SiteColumnDto {
    
    private final long id;
    private final String name;
    private final List<SiteColumnDto> children;
    
    private SiteColumnDto(Builder builder) {
        id = builder.id;
        name = builder.name;
        children = builder.children;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SiteColumnDto> getChildren() {
        return children;
    }
    
    public static class Builder {
        private final long id;
        private final String name;
        private List<SiteColumnDto> children;
        
        public Builder(long id, String name) {
            this.id = id;
            this.name = name;
            this.children = new ArrayList<>();
        }
        
        public Builder addChild(SiteColumnDto column) {
            this.children.add(column);
            return this;
        }
        
        public SiteColumnDto build() {
            return new SiteColumnDto(this);
        }
    }

}
