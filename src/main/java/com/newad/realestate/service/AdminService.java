package com.newad.realestate.service;

import java.util.List;

import com.newad.realestate.controller.dto.PictureGroupDto;
import com.newad.realestate.controller.dto.PropertyDto;
import com.newad.realestate.controller.dto.SiteColumnDto;
import com.newad.realestate.controller.dto.SiteTopicDto;
import com.newad.realestate.model.Page;
import com.newad.realestate.model.ReportRequest;

public interface AdminService {
    
    SiteColumnDto getRootColumnWithFullTree();
    
    SiteColumnDto getColumnById(long id);
    
    void createColumn(long parentId, String columnName);
    
    void deleteColumn(long columnId);
    
    void addTopic(long columnId, String title, String source, String content);
    
    Page<SiteTopicDto> getPagedTopics(int startIndex, int pageSize);
    
    void deleteTopic(long id);
    
    SiteTopicDto getTopic(long id);
    
    void updateTopic(long id, String title, String source, String content);
    
    PropertyDto getPropertyDto(long propertyId);
    
    Long savePropertyBaseInfo(PropertyDto propertyDto);
    
    PictureGroupDto getPropertyPictures(long propertyId);
    
    Page<PropertyDto> getPagedProperties(int startIndex, int pageSize);
    
    void deleteProperty(Long id);
    
    List<ReportRequest> getAllReportRequest();

}
