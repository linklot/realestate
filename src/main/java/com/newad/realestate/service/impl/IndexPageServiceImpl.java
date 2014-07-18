package com.newad.realestate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newad.realestate.controller.dto.IndexPageDto;
import com.newad.realestate.controller.dto.IndexPropertyDto;
import com.newad.realestate.controller.dto.ReportEmailDto;
import com.newad.realestate.controller.dto.SearchFormDto;
import com.newad.realestate.controller.dto.SiteColumnDto;
import com.newad.realestate.controller.dto.SiteTopicDto;
import com.newad.realestate.dao.PropertyDao;
import com.newad.realestate.dao.ReportRequestDao;
import com.newad.realestate.dao.SiteColumnDao;
import com.newad.realestate.dao.SiteTopicDao;
import com.newad.realestate.model.Page;
import com.newad.realestate.model.Property;
import com.newad.realestate.model.ReportRequest;
import com.newad.realestate.model.SiteColumn;
import com.newad.realestate.model.SiteTopic;
import com.newad.realestate.service.EmailService;
import com.newad.realestate.service.IndexPageService;

@Service
@Transactional(readOnly = true)
public class IndexPageServiceImpl implements IndexPageService {
    
    private static final long COLUMN_ZXDT_ID = 3;//最新动态
    private static final long COLUMN_ZCFG_ID = 2;//政策法规
    private static final long COLUMN_TZZN_ID = 4;//投资指南
    private static final long COLUMN_GFXZ_ID = 5;//购房须知
    
    private static final int INDEX_TOPIC_NUMBER = 6;
    
    @Resource
    private PropertyDao propertyDao;
    @Resource
    private SiteColumnDao columnDao;
    @Resource
    private SiteTopicDao topicDao;
    @Resource
    private ReportRequestDao reportRequestDao;
    @Resource
    private EmailService emailService;

    @Override
    public IndexPageDto getIndexPageData() {
        List<Property> properties = propertyDao.getLatest4Properties();
        
        SiteColumn c_zxdt = columnDao.get(COLUMN_ZXDT_ID);
        SiteColumn c_zcfg = columnDao.get(COLUMN_ZCFG_ID);
        SiteColumn c_tzzn = columnDao.get(COLUMN_TZZN_ID);
        SiteColumn c_gfxz = columnDao.get(COLUMN_GFXZ_ID);
        List<SiteTopic> t_zxdt = topicDao.getSomeTopicsByColumnId(COLUMN_ZXDT_ID, INDEX_TOPIC_NUMBER);
        List<SiteTopic> t_zcfg = topicDao.getSomeTopicsByColumnId(COLUMN_ZCFG_ID, INDEX_TOPIC_NUMBER);
        List<SiteTopic> t_tzzn = topicDao.getSomeTopicsByColumnId(COLUMN_TZZN_ID, INDEX_TOPIC_NUMBER);
        List<SiteTopic> t_gfxz = topicDao.getSomeTopicsByColumnId(COLUMN_GFXZ_ID, INDEX_TOPIC_NUMBER);
        
        return new IndexPageDto(properties,
                c_zxdt, c_zcfg, c_tzzn, c_gfxz,
                t_zxdt, t_zcfg, t_tzzn, t_gfxz);
    }

    @Override
    public List<IndexPropertyDto> getCarouselProperties(int number) {
        ArrayList<IndexPropertyDto> properties = new ArrayList<>();
        for(Property p : propertyDao.getCarouselProperties(number)) {
            IndexPropertyDto dto = new IndexPropertyDto(p);
            properties.add(dto);
        }
        return properties;
    }

    @Override
    public List<IndexPropertyDto> searchProperties(SearchFormDto form) {
        Property.NEWORESTABLISHED noe = null;
        if(form.getNewOrEstablished().equals("new")) noe = Property.NEWORESTABLISHED.NEW;
        else if (form.getNewOrEstablished().equals("established")) noe = Property.NEWORESTABLISHED.ESTABLISHED;
        else noe = null;
        
        Property.TYPE type = null;
        switch(form.getType()) {
        case "house":
            type = Property.TYPE.HOUSE;
            break;
        case "townhouse":
            type = Property.TYPE.TOWNHOUSE;
            break;
        case "apartment":
            type = Property.TYPE.APARTMENT;
            break;
        case "unit":
            type = Property.TYPE.UNIT;
            break;
        case "land":
            type = Property.TYPE.LAND;
            break;
        default:
            type = null;
            break;
        }
        
        List<Property> props = propertyDao.search(form.getSuburb(),
                noe, type, form.getBeds(), form.getBathrooms(),
                form.getMinPrice(), form.getMaxPrice());
        
        List<IndexPropertyDto> dtos = new ArrayList<>();
        for(Property p : props) {
            dtos.add(new IndexPropertyDto(p));
        }
        return dtos;
    }

    @Override
    public List<IndexPropertyDto> getAllProperties() {
        List<Property> props = propertyDao.getAll();
        List<IndexPropertyDto> dtos = new ArrayList<>();
        for(Property p : props) {
            dtos.add(new IndexPropertyDto(p));
        }
        return dtos;
    }

    @Override
    public Page<IndexPropertyDto> getPaginatedProperties(int startIndex,
            int pageSize) {
        long totalCount = propertyDao.count();
        List<IndexPropertyDto> dtos = new ArrayList<>();
        
        List<Property> props = propertyDao.getPagedProperties(startIndex, pageSize);
        for(Property prop : props) {
            IndexPropertyDto dto = new IndexPropertyDto(prop);
            dtos.add(dto);
        }
        
        return Page.getPage(dtos, startIndex, pageSize, totalCount);
    }

    @Override
    public IndexPropertyDto getPropertyById(long id) {
        IndexPropertyDto dto = new IndexPropertyDto(propertyDao.get(id));
        return dto;
    }

    @Override
    public List<SiteTopicDto> getTopicsByColumnId(long columnId) {
        List<SiteTopicDto> dtos = new ArrayList<>();
        List<SiteTopic> topics = topicDao.getSomeTopicsByColumnId(columnId, 50);//get 50 topics
        for(SiteTopic t : topics) {
            dtos.add(SiteTopicDto.getNewInstance(t));
        }
        return dtos;
    }

    @Override
    public SiteColumnDto getColumnByColumnId(long columnId) {
        SiteColumn column = columnDao.get(columnId);
        return new SiteColumnDto.Builder(column.getId(), column.getName()).build();
    }

    @Override
    public SiteTopicDto getTopicById(long topicId) {
        SiteTopic topic = topicDao.get(topicId);
        SiteColumn column = topic.getColumn();
        SiteColumnDto columnDto = new SiteColumnDto.Builder(column.getId(),
                column.getName()).build();
        return SiteTopicDto.getNewInstance(topicId, columnDto, topic.getTitle(),
                topic.getTime(), topic.getSource(), topic.getContent());
    }

    @Override
    @Transactional(readOnly = false)
    public void sendReportEmail(String name, String email, String tel,
            String need, Map<String, Boolean> reports) {
        // Save data in db
        ReportRequest req = new ReportRequest(name, email, tel, need, reports);
        reportRequestDao.create(req);
        
        // Send email
        ReportEmailDto msg = new ReportEmailDto(name, email, reports);
        emailService.sendEmail(msg);
    }

}
