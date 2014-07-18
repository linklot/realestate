package com.newad.realestate.dao;

import java.util.List;

import com.newad.realestate.model.SiteTopic;

public interface SiteTopicDao extends Dao<SiteTopic> {
    
    List<SiteTopic> getPagedSiteTopics(int startIndex, int pageSize);
    
    List<SiteTopic> getSomeTopicsByColumnId(long columnId, int number);

}
