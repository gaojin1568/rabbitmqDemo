package com.example.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 订阅模式接收端
 * @author gaojin
 */
@Component
public class ReceiveFanout {
    Logger logger = LoggerFactory.getLogger(ReceiveDirect.class);

    /**
     * 订阅模式A
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "fanout.A")
    public void receivQ(Message message, Channel channel){
        String messageRec = new String(message.getBody());
        logger.info("【订阅模式A】监听队列Q1接收到的信息message=" + messageRec);

        try {
            logger.info("【订阅模式A】开始休息3秒");
            Thread.sleep(3000);
            logger.info("【订阅模式A】休息结束，告诉rabbitmq已经收到消息。");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("【订阅模式A】接受消息时报错=" + e.getMessage());
        }
    }

    /**
     * 订阅模式B
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "fanout.B")
    public void receivQ2(Message message, Channel channel){
        String messageRec = new String(message.getBody());
        logger.info("【订阅模式B】监听队列Q1接收到的信息message=" + messageRec);

        try {
            logger.info("【订阅模式B】开始休息3秒");
            Thread.sleep(3000);
            logger.info("【订阅模式B】休息结束，告诉rabbitmq已经收到消息。");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("【订阅模式B】接受消息时报错=" + e.getMessage());
        }
    }

    /**
     * 订阅模式C
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "fanout.C")
    public void receivQ3(Message message, Channel channel){
        String messageRec = new String(message.getBody());
        logger.info("【订阅模式C】监听队列Q1接收到的信息message=" + messageRec);

        try {
            logger.info("【订阅模式C】开始休息3秒");
            Thread.sleep(3000);
            logger.info("【订阅模式C】休息结束，告诉rabbitmq已经收到消息。");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("【订阅模式C】接受消息时报错=" + e.getMessage());
        }
    }

}
