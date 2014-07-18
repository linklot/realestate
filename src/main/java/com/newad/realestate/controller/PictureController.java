package com.newad.realestate.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newad.realestate.model.Picture;
import com.newad.realestate.service.AdminPictureService;

@Controller
@RequestMapping("/static/propertyPic")
public class PictureController {
    
    @Resource
    private AdminPictureService picService;
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public void getPic(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Picture pic = picService.getPictureById(id);
        Path file = Paths.get(pic.getPath());
        response.setContentType(Files.probeContentType(file));
        InputStream in = Files.newInputStream(file);
        IOUtils.copy(in, response.getOutputStream());
    }

}
