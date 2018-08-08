package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic主题匹配订阅配置中心
 * @author gaojin
 */
@Configuration
public class TopicBindingConfig {

    /**
     * 声明topic的T1队列
     * @return
     */
    @Bean
    public Queue T1() {
        return new Queue("T1",true, false, false);
    }

    /**
     * 声明topic的T2队列
     * @return
     */
    @Bean
    public Queue T2() {
        return new Queue("T2",true, false, false);
    }

    /**
     * 声明topicexchange交换机
     */
    @Bean
    TopicExchange topicexchange() {
        return new TopicExchange("topicexchange");
    }

    /**
     * 定义绑定t.# 发送routingkey为t.开头后面有>=0个字符的消息时 T1能够收到
     * @param T1             队列
     * @param topicexchange 交换机
     */
    @Bean
    Binding bindingExchangeOrange(Queue T1, TopicExchange topicexchange) {
        return BindingBuilder.bind(T1).to(topicexchange).with("t.#");
    }

    /**
     * 定义绑定t.# 发送routingkey为t.fee的消息时 T1能够收到
     * @param T2             队列
     * @param topicexchange 交换机
     */
    @Bean
    Binding bindingExchangeGreen(Queue T2, TopicExchange topicexchange) {
        return BindingBuilder.bind(T2).to(topicexchange).with("t.fee");
    }
}
