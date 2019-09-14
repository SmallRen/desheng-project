package com.desheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desheng.pojo.EmailTemplate;
import com.desheng.service.EmailService;
import com.desheng.util.ResultInfo;

import java.util.List;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/textEmail")
    public Object sendMail(String[] receiver) {
        // emailService.sendEmail(receiver);
        boolean sendEmail = emailService.sendEmail("228689871@qq.com", "1370394516@qq.com");
        return sendEmail;
    }

    @RequestMapping("/queryEmailTemplate")
    public Object queryEmailTemplate() {
        List<EmailTemplate> emailTemplates = emailService.queryEmailTemplate();
        ResultInfo resultPageInfo = ResultInfo.dataInfo(0,  emailTemplates.size(), emailTemplates);
        return resultPageInfo;
    }
}
