package com.example.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Topic 主题匹配订阅
 * @author gaojin
 */
@Component
public class ReceiveTopic {
    Logger logger = LoggerFactory.getLogger(ReceiveDirect.class);

    /**
     * 主题匹配订阅T1
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "T1")
    public void receivQ(Message message, Channel channel){
        String messageRec = new String(message.getBody());
        logger.info("【主题匹配订阅T1】监听队列Q1接收到的信息message=" + messageRec);

        try {
            logger.info("【主题匹配订阅T1】开始休息3秒");
            Thread.sleep(3000);
            logger.info("【主题匹配订阅T1】休息结束，告诉rabbitmq已经收到消息。");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("【主题匹配订阅T1】接受消息时报错=" + e.getMessage());
        }
    }

    /**
     * 主题匹配订阅T2
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "T2")
    public void receivQ2(Message message, Channel channel){
        String messageRec = new String(message.getBody());
        logger.info("【主题匹配订阅T2】监听队列Q1接收到的信息message=" + messageRec);

        try {
            logger.info("【主题匹配订阅T2】开始休息3秒");
            Thread.sleep(3000);
            logger.info("【主题匹配订阅T2】休息结束，告诉rabbitmq已经收到消息。");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("【主题匹配订阅T2】接受消息时报错=" + e.getMessage());
        }
    }

}