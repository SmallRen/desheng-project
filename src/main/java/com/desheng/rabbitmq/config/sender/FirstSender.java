package com.desheng.rabbitmq.config.sender;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desheng.rabbitmq.config.config.RabbitMqConfig;

import java.util.UUID;

/**
 * 消息发送  生产者1
 *
 * @author zhuzhe
 * @date 2018/5/25 14:28
 * @email 1529949535@qq.com
 */
//@Component
public class FirstSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     *
     * @param uuid
     * @param message 消息
     */
    public void send(String uuid, Object message) {
        //发送成功 回调用
        CorrelationData correlationId = new CorrelationData(uuid);
        /**
         * RabbitMqConfig.EXCHANGE  指定消息交换机
         * RabbitMqConfig.ROUTINGKEY2  指定队列key2
         */
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.QUEUEEMAILKEY,
                message, correlationId);
    }

    /**
     * @param exchange      指定消息交换机
     * @param queueemailkey 指定队列key2
     * @param message       发送消息  任意内容，如果是实体 请序列化
     */
    public void send(String exchange, String queueemailkey, Object message) {
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(exchange, queueemailkey,
                message, correlationId);
    }
}
