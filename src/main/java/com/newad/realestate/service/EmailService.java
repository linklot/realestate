package com.newad.realestate.service;

import com.newad.realestate.controller.dto.ReportEmailDto;

public interface EmailService {
    
    void sendEmail(ReportEmailDto msg);

}
