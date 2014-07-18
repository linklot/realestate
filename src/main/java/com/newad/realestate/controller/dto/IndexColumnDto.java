package com.newad.realestate.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.newad.realestate.model.SiteColumn;
import com.newad.realestate.model.SiteTopic;

public class IndexColumnDto {
    
    private long id;
    private String name;
    private List<IndexTopicDto> topics;
    
    private IndexColumnDto() {
        this.topics = new ArrayList<>();
    }
    
    public IndexColumnDto(SiteColumn column, List<SiteTopic> siteTopics) {
        this();
        this.id = column.getId();
        this.name = column.getName();
        for(SiteTopic t : siteTopics) {
            IndexTopicDto topicDto = new IndexTopicDto(t);
            this.topics.add(topicDto);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<IndexTopicDto> getTopics() {
        return topics;
    }

}
