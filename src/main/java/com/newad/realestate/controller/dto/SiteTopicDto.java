package com.newad.realestate.controller.dto;

import java.util.Calendar;

import com.newad.realestate.model.SiteTopic;
import com.newad.realestate.util.EnvUtil;

public class SiteTopicDto {
    
    private final long id;
    private final SiteColumnDto column;
    private final String title;
    private final Calendar time;
    private final String source;
    private final String content;
    
    private SiteTopicDto(long id, SiteColumnDto column,
            String title, Calendar time, String source,
            String content) {
        this.id = id;
        this.column = column;
        this.title = title;
        this.time = time;
        this.source = source;
        this.content = content;
    }
    
    public static SiteTopicDto getNewInstance(long id, SiteColumnDto column,
            String title, Calendar time, String source, String content) {
        return new SiteTopicDto(id, column, title, time, source, content);
    }
    
    public static SiteTopicDto getNewInstance(SiteTopic topic) {
        return new SiteTopicDto(topic.getId(), null, topic.getTitle(),
                topic.getTime(), topic.getSource(), topic.getContent());
    }

    public long getId() {
        return id;
    }

    public SiteColumnDto getColumn() {
        return column;
    }

    public String getTitle() {
        return title;
    }

    public String getSource() {
        return source;
    }

    public String getContent() {
        return content;
    }
    
    public String getReadableTime() {
        return EnvUtil.formatCalendar(this.time);
    }

}
