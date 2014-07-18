package com.newad.realestate.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.newad.realestate.controller.dto.AddSubColumnForm;
import com.newad.realestate.controller.dto.AddTopicForm;
import com.newad.realestate.controller.dto.PictureGroupDto;
import com.newad.realestate.controller.dto.PropertyDto;
import com.newad.realestate.controller.dto.SiteColumnDto;
import com.newad.realestate.controller.dto.SiteTopicDto;
import com.newad.realestate.model.Page;
import com.newad.realestate.model.ReportRequest;
import com.newad.realestate.service.AdminPictureService;
import com.newad.realestate.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Resource
    private AdminService adminService;
    
    @Resource
    private AdminPictureService pictureService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String adminIndex() {
        return "/admin/adminIndex";
    }
    
    @RequestMapping(value = "columnTree", method = RequestMethod.GET)
    public @ResponseBody SiteColumnDto getColumnTree() {
        return adminService.getRootColumnWithFullTree();
    }
    
    @RequestMapping(value= "column/{id}", method = RequestMethod.GET)
    public @ResponseBody SiteColumnDto getColumn(@PathVariable Long id) {
        return adminService.getColumnById(id);
    }
    
    @RequestMapping(value = "column", method = RequestMethod.POST, consumes="application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public void addSubColumn(@RequestBody AddSubColumnForm form) {
        adminService.createColumn(form.getParentColumnId(),
                form.getColumnName());
    }
    
    @RequestMapping(value = "column/{id}/delete", method = RequestMethod.GET)
    @ResponseStatus(value=HttpStatus.OK)
    public void deleteColumn(@PathVariable Long id) {
        adminService.deleteColumn(id);
    }
    
    @RequestMapping(value = "topic", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public void addTopic(@RequestBody AddTopicForm form) {
        adminService.addTopic(form.getColumnId(), form.getTitle(),
                form.getSource(), form.getContent());
    }
    
    @RequestMapping(value = "topics", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody Page<SiteTopicDto> getPagedTopics(@RequestBody Map<String, Integer> data) {
        return adminService.getPagedTopics(
                data.get("startIndex"), data.get("pageSize"));
    }
    
    @RequestMapping(value = "topic/del", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTopic(@RequestBody Map<String, Long> data) {
        long id = data.get("id").longValue();
        adminService.deleteTopic(id);
    }
    
    @RequestMapping(value = "topic/{id}", method = RequestMethod.GET)
    public @ResponseBody SiteTopicDto getTopic(@PathVariable Long id) {
        return adminService.getTopic(id);
    }
    
    @RequestMapping(value = "topic/{id}", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public void modifyTopic(@RequestBody Map<String, Object> topic) {
        long id = ((Integer) topic.get("id")).longValue();
        String title = (String) topic.get("title");
        String source = (String) topic.get("source");
        String content = (String) topic.get("content");
        adminService.updateTopic(id, title, source, content);
    }
    
    @RequestMapping(value = "/property/{propertyId}", method = RequestMethod.GET)
    @ResponseBody
    public PropertyDto preAddProperty(@PathVariable Long propertyId) {
        return adminService.getPropertyDto(propertyId);
    }
    
    @RequestMapping(value = "/property", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Long savePropertyBaseInfo(@RequestBody PropertyDto propertyDto) {
        return adminService.savePropertyBaseInfo(propertyDto);
    }
    
    @RequestMapping(value = "/property/{id}/pictures", method = RequestMethod.GET)
    @ResponseBody
    public PictureGroupDto getPropertyPictures(@PathVariable Long id) {
        return adminService.getPropertyPictures(id);
    }
    
    @RequestMapping(value = "propertyList", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody Page<PropertyDto> getPagedProperties(@RequestBody Map<String, Integer> data) {
        return adminService.getPagedProperties(data.get("startIndex"), data.get("pageSize"));
    }
    
    @RequestMapping(value = "/property/picGroup/pic", method = RequestMethod.POST)
    public @ResponseBody boolean uploadPropertyPicture(@RequestParam MultipartFile file,
            Long picGroupId) {
        return pictureService.savePicture(picGroupId, file);
    }
    
    @RequestMapping(value = "/property/picture/{id}/delete", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePropertyPicture(@PathVariable Long id) {
        pictureService.deletePicture(id);
    }
    
    @RequestMapping(value = "/property/{id}/delete", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProperty(@PathVariable Long id) {
        adminService.deleteProperty(id);
    }
    
    @RequestMapping(value = "/reportRequests", method = RequestMethod.GET)
    public @ResponseBody List<ReportRequest> listReportRequest() {
        return adminService.getAllReportRequest();
    }

}
