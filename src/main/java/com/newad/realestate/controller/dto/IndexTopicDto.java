package com.newad.realestate.controller.dto;

import com.newad.realestate.model.SiteTopic;
import com.newad.realestate.util.EnvUtil;

public class IndexTopicDto {
    
    private long id;
    private String title;
    private String time;
    
    private IndexTopicDto() {}
    
    public IndexTopicDto(SiteTopic topic) {
        this();
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.time = EnvUtil.formatCalendarShort(topic.getTime());
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

}
