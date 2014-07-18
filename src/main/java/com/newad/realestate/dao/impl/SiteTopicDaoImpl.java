package com.newad.realestate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.newad.realestate.dao.SiteTopicDao;
import com.newad.realestate.model.SiteTopic;

@Repository
public class SiteTopicDaoImpl extends AbstractHbnDao<SiteTopic> implements
        SiteTopicDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<SiteTopic> getPagedSiteTopics(int startIndex, int pageSize) {
        return (List<SiteTopic>) super.getSession()
            .getNamedQuery("SiteTopic.findAll")
            .setFirstResult(startIndex)
            .setMaxResults(pageSize)
            .list();
    }
    
    @SuppressWarnings("unchecked")
    public List<SiteTopic> getSomeTopicsByColumnId(long columnId, int number) {
        return super.getSession()
        .getNamedQuery("SiteTopic.findSomeByColumnId")
        .setLong("columnId", columnId)
        .setFirstResult(0)
        .setMaxResults(number)
        .list();
    }

}
