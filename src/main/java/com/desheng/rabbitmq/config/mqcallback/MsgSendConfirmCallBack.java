package com.desheng.rabbitmq.config.mqcallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * 消息发送到交换机确认机制
 *
 * @author zhuzhe
 * @date 2018/5/25 15:53
 * @email 1529949535@qq.com
 */
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {
    private static Logger log = LoggerFactory.getLogger(MsgSendConfirmCallBack.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("MsgSendConfirmCallBack  , 回调id:" + correlationData);
        if (ack) {
            log.info("消息消费成功");
        } else {
            log.info("消息消费失败:" + cause + "\n重新发送");
        }
    }
}
