package com.newad.realestate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.newad.realestate.controller.dto.IndexPropertyDto;
import com.newad.realestate.controller.dto.ReportRequestDto;
import com.newad.realestate.controller.dto.SearchFormDto;
import com.newad.realestate.model.Page;
import com.newad.realestate.service.IndexPageService;
import com.newad.realestate.service.UserService;

@Controller
@RequestMapping("/")
public class DefaultController {
    
    private final int CAROUSEL_NUMBER = 4;// Carousel property number
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private IndexPageService indexPageService;
    
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String siteIndex(Model model) {
        model.addAttribute("data", indexPageService.getIndexPageData());
        return "index";
    }
    
    @RequestMapping(value = "/carouselProperties", method = RequestMethod.GET)
    public @ResponseBody List<IndexPropertyDto> getCarouselProperties() {
        return indexPageService.getCarouselProperties(CAROUSEL_NUMBER);
    }
    
    @RequestMapping(value = "header", method = RequestMethod.GET)
    public String siteHeader() {
        return "header";
    }
    
    @RequestMapping(value = "footer", method = RequestMethod.GET)
    public String siteFooter() {
        return "footer";
    }
    
    @RequestMapping(value = "admin_signin", method = RequestMethod.GET)
    public String adminSignInPage() {
        return "admin_signin";
    }
    
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@ModelAttribute("form") SearchFormDto form, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("properties", indexPageService.searchProperties(form));
        return "redirect:searchResult";
    }
    
    @RequestMapping(value = "searchResult", method = RequestMethod.GET)
    public String searchResult() {
        return "searchResult";
    }
    
    @RequestMapping(value = "/property/{id}", method = RequestMethod.GET)
    public String showProperty(@PathVariable Long id, Model model) {
        model.addAttribute("property", indexPageService.getPropertyById(id));
        return "property";
    }
    
    @RequestMapping(value = "/column/{id}", method = RequestMethod.GET)
    public String showColumnTopics(@PathVariable Long id, Model model) {
        model.addAttribute("column", indexPageService.getColumnByColumnId(id));
        model.addAttribute("topics", indexPageService.getTopicsByColumnId(id));
        return "column";
    }
    
    @RequestMapping(value = "/topic/{id}", method = RequestMethod.GET)
    public String showTopic(@PathVariable Long id, Model model) {
        model.addAttribute("topic", indexPageService.getTopicById(id));
        return "topic";
    }
    
    @RequestMapping(value = "sendEmail", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendEmail(@RequestBody ReportRequestDto reportRequest) {
        String name = reportRequest.getName();
        String email = reportRequest.getEmail();
        String tel = reportRequest.getTel();
        String need = reportRequest.getNeed();
        Map<String, Boolean> reports = reportRequest.getReports();
        indexPageService.sendReportEmail(name, email, tel, need, reports);
    }
    
    @RequestMapping(value = "/properties", method = RequestMethod.GET)
    public String showAllProperties() {
        return "properties";
    }
    
    @RequestMapping(value = "/paginatedProperties", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody Page<IndexPropertyDto> getPaginatedProperties(@RequestBody Map<String, Integer> data) {
        int startIndex = data.get("startIndex");
        int pageSize = data.get("pageSize");
        return indexPageService.getPaginatedProperties(startIndex, pageSize);
    }
    
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }

}
