package com.newad.realestate.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newad.realestate.controller.dto.PictureGroupDto;
import com.newad.realestate.controller.dto.PropertyDto;
import com.newad.realestate.controller.dto.SiteColumnDto;
import com.newad.realestate.controller.dto.SiteTopicDto;
import com.newad.realestate.dao.PictureDao;
import com.newad.realestate.dao.PictureGroupDao;
import com.newad.realestate.dao.PropertyDao;
import com.newad.realestate.dao.ReportRequestDao;
import com.newad.realestate.dao.SiteColumnDao;
import com.newad.realestate.dao.SiteTopicDao;
import com.newad.realestate.model.Page;
import com.newad.realestate.model.PictureGroup;
import com.newad.realestate.model.Property;
import com.newad.realestate.model.ReportRequest;
import com.newad.realestate.model.SiteColumn;
import com.newad.realestate.model.SiteTopic;
import com.newad.realestate.service.AdminService;
import com.newad.realestate.util.EnvUtil;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {
    
    private final String PROPERTY_CODE_BASE = "10112100";
    
    @Resource
    private SiteColumnDao columnDao;
    @Resource
    private SiteTopicDao topicDao;
    @Resource
    private PropertyDao propertyDao;
    @Resource
    private PictureGroupDao pictureGroupDao;
    @Resource
    private PictureDao pictureDao;
    @Resource
    private ReportRequestDao reportRequestDao;

    @Override
    public SiteColumnDto getRootColumnWithFullTree() {
        SiteColumn rootColumn = columnDao.getRootColumnWithFullColumnTree();
        return siteColumnToSiteColumnDto(rootColumn);
    }
    
    @Override
    public SiteColumnDto getColumnById(long id) {
        SiteColumn column = columnDao.get(id);
        String name = column.getName();
        return new SiteColumnDto.Builder(id, name).build();
    }

    @Override
    @Transactional(readOnly = false)
    public void createColumn(long parentId, String columnName) {
        SiteColumn parentColumn = columnDao.get(parentId);
        SiteColumn column = new SiteColumn(parentColumn, columnName);
        columnDao.create(column);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteColumn(long columnId) {
        columnDao.deleteById(columnId);
    }

    @Override
    @Transactional(readOnly = false)
    public void addTopic(long columnId, String title, String source,
            String content) {
        Calendar cal = EnvUtil.getCurrentLocalTime();
        SiteColumn column = columnDao.get(columnId);
        SiteTopic topic = new SiteTopic(column, title, cal, source,
                content);
        topicDao.create(topic);
    }

    @Override
    public Page<SiteTopicDto> getPagedTopics(int startIndex, int pageSize) {
        int totalCount = ((Long)topicDao.count()).intValue();
        
        List<SiteTopicDto> items = new ArrayList<SiteTopicDto>();
        List<SiteTopic> topics = topicDao.getPagedSiteTopics(startIndex, pageSize);
        for(SiteTopic topic : topics) {
            SiteColumn column = topic.getColumn();
            SiteColumnDto columnDto = new SiteColumnDto
                    .Builder(column.getId(), column.getName())
                    .build();
            SiteTopicDto dto = SiteTopicDto.getNewInstance(
                    topic.getId(),
                    columnDto,
                    topic.getTitle(),
                    topic.getTime(),
                    topic.getSource(),
                    topic.getContent());
            items.add(dto);
        }
        
        return Page.getPage(items, startIndex, pageSize, totalCount);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteTopic(long id) {
        topicDao.deleteById(id);
    }

    @Override
    public SiteTopicDto getTopic(long id) {
        SiteTopic topic = topicDao.get(id);
        SiteColumn column = topic.getColumn();
        SiteColumnDto columnDto = new SiteColumnDto
                .Builder(column.getId(), column.getName())
                .build();
        SiteTopicDto dto = SiteTopicDto.getNewInstance(
                topic.getId(),
                columnDto,
                topic.getTitle(),
                topic.getTime(),
                topic.getSource(),
                topic.getContent());
        return dto;
    }

    @Override
    @Transactional(readOnly = false)
    public void updateTopic(long id, String title, String source, String content) {
        SiteTopic topic = topicDao.get(id);
        topic.setTitle(title);
        topic.setSource(source);
        topic.setContent(content);
        topicDao.update(topic);
    }

    @Override
    public PropertyDto getPropertyDto(long propertyId) {
        Property p;
        if(0 == propertyId) {
            p = new Property.Builder("", "")
                .feature("")
                .introduction("")
                .propertyType(Property.TYPE.HOUSE)
                .newOrEstablished(Property.NEWORESTABLISHED.ESTABLISHED)
                .price(0)
                .beds(1)
                .bathrooms(1)
                .carSpaces(0)
                .landSize(0.0f)
                .pictureGroup(PictureGroup.getInstance())
                .suburb("")
                .carousel(false)
                .agency("")
                .contact("")
                .contactNote("")
                .build();
        } else {
            p = propertyDao.get(propertyId);
        }
        return new PropertyDto(p);
    }

    @Override
    @Transactional(readOnly = false)
    public Long savePropertyBaseInfo(PropertyDto dto) {
        if(dto.getId() <= 0l) {
            /* to create a new Property */
            /* create a PictureGroup instance */
            PictureGroup group = PictureGroup.getInstance();
            long groupId = pictureGroupDao.create(group);
            group.setId(groupId);
            
            /* fetch a new property code */
            String propertyCode = generatePropertyCode();
            
            /* generate a new property instance */
            Property property = new Property.Builder(propertyCode, dto.getAddress())
                .suburb(dto.getSuburb())
                .feature(dto.getFeature())
                .introduction(dto.getIntroduction())
                .propertyType(dto.getPropertyType())
                .newOrEstablished(dto.getNewOrEstablished())
                .price(dto.getPrice())
                .beds(dto.getBeds())
                .bathrooms(dto.getBathrooms())
                .carSpaces(dto.getCarSpaces())
                .landSize(dto.getLandSize())
                .pictureGroup(group)
                .carousel(dto.isCarousel())
                .agency(dto.getAgency())
                .contact(dto.getContact())
                .contactNote(dto.getContactNote())
                .build();
            
            /* save the instance */
            return propertyDao.create(property);
        } else {
            /* to modify a Property */
            Property p = propertyDao.get(dto.getId());
            p.setAddress(dto.getAddress());
            p.setPropertyType(dto.getPropertyType());
            p.setPrice(dto.getPrice());
            p.setSuburb(dto.getSuburb());
            p.setBeds(dto.getBeds());
            p.setBathrooms(dto.getBathrooms());
            p.setCarSpaces(dto.getCarSpaces());
            p.setNewOrEstablished(dto.getNewOrEstablished());
            p.setLandSize(dto.getLandSize());
            p.setFeature(dto.getFeature());
            p.setIntroduction(dto.getIntroduction());
            p.setCarousel(dto.isCarousel());
            p.setAgency(dto.getAgency());
            p.setContact(dto.getContact());
            p.setContactNote(dto.getContactNote());
            propertyDao.update(p);
            return p.getId();
        }
    }

    @Override
    public PictureGroupDto getPropertyPictures(long propertyId) {
        Property p = propertyDao.get(propertyId);
        PictureGroup group = p.getPictureGroup();
        return new PictureGroupDto(group);
    }

    @Override
    public Page<PropertyDto> getPagedProperties(int startIndex, int pageSize) {
        int totalCount = ((Long)propertyDao.count()).intValue();
        
        List<PropertyDto> items = new ArrayList<>();
        List<Property> properties = propertyDao.getPagedProperties(startIndex, pageSize);
        for(Property p : properties) {
            PropertyDto dto = new PropertyDto(p);
            items.add(dto);
        }
        
        return Page.getPage(items, startIndex, pageSize, totalCount);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteProperty(Long id) {
        propertyDao.deleteById(id);
    }

    @Override
    public List<ReportRequest> getAllReportRequest() {
        return reportRequestDao.getAllInOrder();
    }

    private SiteColumnDto siteColumnToSiteColumnDto(SiteColumn rootColumn) {
        long root_id = rootColumn.getId();
        String root_name = rootColumn.getName();
        SiteColumnDto.Builder builder = new SiteColumnDto.Builder(root_id, root_name);
        Set<SiteColumn> children = rootColumn.getChildren();
        if(children.size() > 0) {
            for(SiteColumn child : children) {
                builder.addChild(siteColumnToSiteColumnDto(child));
            }
        }
        return builder.build();
    }

    private String generatePropertyCode() {
        int last_code = Integer.parseInt(propertyDao.getLastPropertyCode());
        if(last_code == 0) return PROPERTY_CODE_BASE;
        else return String.valueOf(last_code + 1);
    }

}
