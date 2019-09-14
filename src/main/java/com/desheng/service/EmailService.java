package com.desheng.service;

import java.util.List;

import com.desheng.pojo.EmailTemplate;

public interface EmailService {
    /**
     * 发送普通文本邮件
     *
     * @param receiver 接收者
     * @return
     */
    boolean sendEmail(String... receiver);


    /**
     * 发送html格式邮件
     *
     * @param html     html文本内容
     * @param receiver 接收者
     * @return
     */
    Object sendHtmlEmail(String html, String... receiver);

    /***
     * 发送附件邮件
     * @param receiver
     * @return
     */
    Object sendFilesEmail(String... receiver);

    /***
     * 发送图片邮件
     * @param receiver
     * @return
     */
    Object sendInlineResourceMail(String... receiver);

    /**
     * 查询邮件模板
     *
     * @return
     */
    List<EmailTemplate> queryEmailTemplate();
}
