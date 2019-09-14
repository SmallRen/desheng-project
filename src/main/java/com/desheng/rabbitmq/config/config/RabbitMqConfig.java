package com.desheng.rabbitmq.config.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

import com.desheng.rabbitmq.config.mqcallback.MsgSendConfirmCallBack;
import com.desheng.rabbitmq.config.mqcallback.MsgSendReturnCallback;

import javax.annotation.Resource;

/**
 * RabbitMq配置
 *
 * @author zhuzhe
 * @date 2018/5/25 13:37
 * @email 1529949535@qq.com
 */
//为了接收JSON数据，我们应该通过实现RabbitListenerConfigurer来定制RabbitMQ配置。
//@Configuration
public class RabbitMqConfig {

    /**
     * 消息交换机的名字
     */
    public static final String EXCHANGE = "exchangeTest";
    /*对列名称*/
    public static final String QUEUE_NAME1 = "first-queue";
    public static final String QUEUE_NAME2 = "second-queue";
    public static final String EmailQueue = "email-queue";//邮件

    /*
     *
     * key: queue在该direct-exchange中的key值，当消息发送给direct-exchange中指定key为设置值时，
     *   消息将会转发给queue参数指定的消息队列
     */
    /**
     * 队列key1
     */
    public static final String ROUTINGKEY1 = "queue_one_key1";
    /**
     * 队列key2
     */
    public static final String ROUTINGKEY2 = "queue_one_key2";
    /**
     * 邮件队列key
     */
    public static final String QUEUEEMAILKEY = "queue_email_key";

    @Resource
    private QueueConfig queueConfig;
    @Resource
    private ExchangeConfig exchangeConfig;

    /**
     * 连接工厂
     */
    @Resource
    private ConnectionFactory connectionFactory;

    /**
     * 将消息队列1和交换机进行绑定,指定队列key1
     */
    @Bean
    public Binding binding_one() {
        return BindingBuilder.bind(queueConfig.firstQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTINGKEY1);
    }

    /**
     * 将消息队列2和交换机进行绑定,指定队列key2
     */
    @Bean
    public Binding binding_two() {
        return BindingBuilder.bind(queueConfig.secondQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTINGKEY2);
    }

    @Bean
    public Binding binding_three() {
        return BindingBuilder.bind(queueConfig.emailQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.QUEUEEMAILKEY);
    }

    /**
     * queue listener  观察 监听模式
     * 当有消息到达时会通知监听在对应的队列上的监听对象
     *
     * @return
     */
    /*
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer_one() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
        simpleMessageListenerContainer.setQueues(queueConfig.emailQueue());
        simpleMessageListenerContainer.setExposeListenerChannel(true);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(5);
        simpleMessageListenerContainer.setConcurrentConsumers(1);
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        return simpleMessageListenerContainer;
    }
*/

    /**
     * 自定义rabbit template用于数据的接收和发送
     * 可以设置消息确认机制和回调
     *
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        //可以自定义消息转换器 默认使用的JDK的，所以消息对象需要实现Serializable
        template.setMessageConverter(new Jackson2JsonMessageConverter());

        /**若使用confirm-callback或return-callback，
         * 必须要配置publisherConfirms或publisherReturns为true
         * 每个rabbitTemplate只能有一个confirm-callback和return-callback
         */
        template.setConfirmCallback(msgSendConfirmCallBack());

        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定’mandatory’的boolean值，
         * 只能在提供’return -callback’时使用，与mandatory互斥
         */
        template.setReturnCallback(msgSendReturnCallback());
        template.setMandatory(true);
        return template;
    }


    /*  关于 msgSendConfirmCallBack 和 msgSendReturnCallback 的回调说明：
        1.如果消息没有到exchange,则confirm回调,ack=false
        2.如果消息到达exchange,则confirm回调,ack=true
        3.exchange到queue成功,则不回调return
        4.exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
    */

    /**
     * 消息确认机制
     * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
     * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。(两者不可同时使用)
     * 在channel为事务时，不可引入确认模式；同样channel为确认模式下，不可使用事务。
     *
     * @return
     */
    @Bean
    public MsgSendConfirmCallBack msgSendConfirmCallBack() {
        return new MsgSendConfirmCallBack();
    }

    @Bean
    public MsgSendReturnCallback msgSendReturnCallback() {
        return new MsgSendReturnCallback();
    }

    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }
}