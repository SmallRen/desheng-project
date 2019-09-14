package com.desheng.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.desheng.mapper.EmailTemplateMapper;
import com.desheng.pojo.EmailTemplate;
import com.desheng.service.EmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.fromMail.sender}")
    private String sender;//发送者
    @Autowired
    private EmailTemplateMapper emailTemplateMapper;


    private static Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public boolean sendEmail(String... receiver) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);//可变长参数
        message.setSubject("文本邮件测试");//邮件标题
        message.setText("你好！ hello word");//主题内容
        try {
            javaMailSender.send(message);
            log.info("发送文本邮件成功");
            return true;
        } catch (MailException e) {
            log.error("发送文本邮件失败", e);
            return false;
        }
    }

    @Override
    public Object sendHtmlEmail(String html, String... receiver) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            //true表示需要创建一个多类型的 multipart message
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("HTML邮件测试");
            helper.setText(html, true);
            javaMailSender.send(mimeMessage);
            log.info("发送HTML邮件成功");
            return true;
        } catch (MessagingException e) {
            log.error("发送HTML邮件失败", e);
            return false;
        }
    }

    @Override
    public Object sendFilesEmail(String... receiver) {
        String filePath = "F:\\select_from_user.sql";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("邪客发送附件邮件测试");
            helper.setText("一封带附件的邮件", true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            javaMailSender.send(message);
            log.info("附件邮件发送成功！");
            return "success";
        } catch (MessagingException e) {
            log.error("附件邮件发送异常！", e);
            return "failure";
        }
    }

    @Override
    public Object sendInlineResourceMail(String... receiver) {
        String id = "xieke90";
        // cid:内嵌资源
        String content = "<html><body>带有图片的邮件：<img src=\'cid:" + id + "\'></body></html>";
        String imgPath = "F:\\spring-cloud.png";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("邪客发送图片邮件测试");
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(imgPath));
            helper.addInline(id, res);

            javaMailSender.send(message);
            log.info("图片邮件发送成功！");
            return "success";
        } catch (MessagingException e) {
            log.error("图片邮件发送异常！", e);
            return "failure";
        }

    }

    @Override
    public List<EmailTemplate> queryEmailTemplate() {
        List<EmailTemplate> emailTemplates = emailTemplateMapper.selectByExample(null);
        return emailTemplates;
    }
}
