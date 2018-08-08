package com.example.rabbitmq.consumer;

import com.example.rabbitmq.entity.User;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Direct exchange:通过bindingkey的完全匹配
 * @author gaojin
 */
@Component
public class ReceiveDirect {
    Logger logger = LoggerFactory.getLogger(ReceiveDirect.class);

    /**
     * 接收队列Q1的消息
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "Q1")
    public void receivQ1(Message message,Channel channel){
        String messageRec = new String(message.getBody());
        logger.info("【接收队列Q1的消息】监听队列Q1接收到的信息message=" + messageRec);

        try {
            logger.info("【接收队列Q1的消息】开始休息3秒");
            Thread.sleep(3000);
            logger.info("【接收队列Q1的消息】休息结束，告诉rabbitmq已经收到消息。");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("【接收队列Q1的消息】接受消息时报错=" + e.getMessage());
        }
    }

    /**
     * 接收队列Q2的消息
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "Q2")
    public void receivQ2(Message message,Channel channel){
        String messageRec = new String(message.getBody());
        logger.info("【接收队列Q2的消息】监听队列Q2接收到的信息message=" + messageRec);

        try {
            logger.info("【接收队列Q2的消息】开始休息3秒");
            Thread.sleep(3000);
            logger.info("【接收队列Q2的消息】休息结束，告诉rabbitmq已经收到消息。");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("【接收队列Q2的消息】接受消息时报错=" + e.getMessage());
        }
    }

    /**
     * 接收队列bean的消息
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "bean")
    public void receivBean(User user, Message message, Channel channel){
        logger.info("【接收队列Q2的消息】监听队列Q2接收到的信息message=" + user);

        try {
            logger.info("【接收队列bean的消息】开始休息3秒");
            Thread.sleep(3000);
            logger.info("【接收队列bean的消息】休息结束，告诉rabbitmq已经收到消息。");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("【接收队列bean的消息】接受消息时报错=" + e.getMessage());
        }
    }

}