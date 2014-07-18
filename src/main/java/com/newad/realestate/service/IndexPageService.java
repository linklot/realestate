package com.newad.realestate.service;

import java.util.List;
import java.util.Map;

import com.newad.realestate.controller.dto.IndexPageDto;
import com.newad.realestate.controller.dto.IndexPropertyDto;
import com.newad.realestate.controller.dto.SearchFormDto;
import com.newad.realestate.controller.dto.SiteColumnDto;
import com.newad.realestate.controller.dto.SiteTopicDto;
import com.newad.realestate.model.Page;

public interface IndexPageService {
    
    IndexPageDto getIndexPageData();
    
    List<IndexPropertyDto> getCarouselProperties(int number);
    
    List<IndexPropertyDto> searchProperties(SearchFormDto form);
    
    List<IndexPropertyDto> getAllProperties();
    
    Page<IndexPropertyDto> getPaginatedProperties(int startIndex
            ,int pageSize);
    
    IndexPropertyDto getPropertyById(long id);
    
    List<SiteTopicDto> getTopicsByColumnId(long columnId);
    
    SiteColumnDto getColumnByColumnId(long columnId);
    
    SiteTopicDto getTopicById(long topicId);
    
    void sendReportEmail(String name, String email, String tel, String need,
            Map<String, Boolean> reports);

}
