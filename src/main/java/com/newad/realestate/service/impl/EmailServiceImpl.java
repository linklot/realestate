package com.newad.realestate.service.impl;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.newad.realestate.controller.dto.ReportEmailDto;
import com.newad.realestate.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
    
    private final String DATA_PATH = "OPENSHIFT_DATA_DIR";
    private String REPORT_REAL_PATH;
    
    private final String FROM = "info@newad.com.au";
    private final String SUBJECT = "新澳东为您提供免费报告";
    private final String TEXT = "报告文本";
    private final String HOST = "smtpout.asia.secureserver.net";
    private final String PORT = "25";
    private final String USERNAME = "info@newad.com.au";
    private final String PASSWORD = "Newad123456";
    
    @PostConstruct
    public void init() {
        this.REPORT_REAL_PATH = System.getenv(DATA_PATH) + "/free_reports/";
    }

    @Override
    @Async
    public void sendEmail(ReportEmailDto msg) {
        try {
            Transport.send(createEmail(msg));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private Message createEmail(ReportEmailDto msg) {
        Message message = new MimeMessage(getSession());
        
        try {
            message.setFrom(new InternetAddress(FROM));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(msg.getEmail()));
            message.setSubject(SUBJECT);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(TEXT);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            
            addAttachment(multipart, msg.getReports());
            
            message.setContent(multipart);
            
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return message;
    }
    
    private Session getSession() {
        return Session.getInstance(getProperties(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                }
        );
    }
    
    private Properties getProperties() {
        Properties props = new Properties();
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        
        return props;
    }
    
    private void addAttachment(Multipart multipart, List<String> reports) throws Exception {
        if(reports.size() > 0) {
            for(String name : reports) {
                BodyPart messageBodyPart = new MimeBodyPart();
                DataSource source;
                switch(name) {
                case "gfzn":
                    source = new FileDataSource(REPORT_REAL_PATH + "gfzn.pdf");
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(MimeUtility.encodeWord("澳洲购房指南.pdf"));
                    break;
                case "tzym":
                    source = new FileDataSource(REPORT_REAL_PATH + "tzym.pdf");
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(MimeUtility.encodeWord("澳洲商业投资移民签证简介.pdf"));
                    break;
                case "jsym":
                    source = new FileDataSource(REPORT_REAL_PATH + "jsym.pdf");
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(MimeUtility.encodeWord("澳洲独立技术移民简介.pdf"));
                    break;
                case "gzdb":
                    source = new FileDataSource(REPORT_REAL_PATH + "gzdb.pdf");
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(MimeUtility.encodeWord("澳洲雇主担保移民简介.pdf"));
                    break;
                case "dxlx":
                    source = new FileDataSource(REPORT_REAL_PATH + "dxlx.pdf");
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(MimeUtility.encodeWord("大学生留学方案.pdf"));
                    break;
                case "zxlx":
                    source = new FileDataSource(REPORT_REAL_PATH + "zxlx.pdf");
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(MimeUtility.encodeWord("中学生留学方案.pdf"));
                    break;
                default:
                    break;
                }
                multipart.addBodyPart(messageBodyPart);
            }
        }
    }

}
