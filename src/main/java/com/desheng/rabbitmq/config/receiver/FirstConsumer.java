package com.desheng.rabbitmq.config.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.desheng.pojo.User;
import com.desheng.service.EmailService;

import java.io.UnsupportedEncodingException;

/**
 * 消息消费者1
 *
 * @author zhuzhe
 * @date 2018/5/25 17:32
 * @email 1529949535@qq.com
 */
//@Component
public class FirstConsumer {
    private static Logger log = LoggerFactory.getLogger(FirstConsumer.class);
    @Autowired
    private EmailService emailService;

    /**
     * queues  指定从哪个队列（queue）订阅消息
     *
     * @param message
     */
    @RabbitListener(queues = {"first-queue"})
    public void handleMessage(Message message) {
        // 处理消息
        log.info("FirstConsumer {} handleMessage :" + message);
    }

    @RabbitListener(queues = {"email-queue"})
    //使用 @Payload 和 @Headers 注解可以消息中的 body 与 headers 信息 https://www.jianshu.com/p/911d987b5f11
    /**
     * 给注册用户发送邮件
     */
    public void handleEmailMessage(@Payload User user) throws UnsupportedEncodingException {
        // 处理消息
        StringBuilder str = new StringBuilder();
        str.append("<html>");
        str.append("<body>");
        str.append("注册成功请牢记账号密码");
        str.append("<h3>账号：" + user.getUsername() + "</h3>");
        str.append("<h3>密码：" + user.getPassword() + "</h3>");
        str.append("<a href='http://localhost:8088'>点击登陆</a>");
        str.append("</body>");
        str.append("</html>");
        emailService.sendHtmlEmail( str.toString(),"1370394516@qq.com");
        log.info("EmailConsumer {} handleMessage :" + user);
    }
}
