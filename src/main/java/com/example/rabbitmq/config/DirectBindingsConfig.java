package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Direct Exchange 直接匹配 配置中心
 * @author gaojin
 */
@Configuration
public class DirectBindingsConfig {

    /**
     * 声明Direct的orange队列
     */
    @Bean
    public Queue Q1() {
        return new Queue("Q1",true, false, false);
    }

    /**
     * 声明Direct的black队列
     */
    @Bean
    public Queue Q2() {
        return new Queue("Q2",true, false, false);
    }
    /**
     * 声明Direct的black队列
     */
    @Bean
    public Queue bean() {
        return new Queue("bean",true, false, false);
    }

    /**
     * 声明directexchange交换机
     */
    @Bean
    DirectExchange directexchange() {
        return new DirectExchange("directexchange");
    }

    /**
     * 定义绑定green 发送routingkey为green的消息时 Q1能够收到
     * @param Q1             队列
     * @param directexchange 交换机
     */
    @Bean
    Binding bindingExchangeOrange(Queue Q1, DirectExchange directexchange) {
        return BindingBuilder.bind(Q1).to(directexchange).with("green");
    }

    /**
     * 定义绑定green 发送routingkey为green的消息时 Q2能够收到
     * @param Q2             队列
     * @param directexchange 交换机
     */
    @Bean
    Binding bindingExchangeGreen(Queue Q2, DirectExchange directexchange) {
        return BindingBuilder.bind(Q2).to(directexchange).with("green");
    }

    /**
     * 定义绑定black 发送routingkey为black的消息时 Q2能够收到
     * @param Q2             队列
     * @param directexchange 交换机
     */
    @Bean
    Binding bindingExchangeBlack(Queue Q2, DirectExchange directexchange) {
        return BindingBuilder.bind(Q2).to(directexchange).with("black");
    }

    /**
     * 定义绑定bean 发送routingkey为bean的消息时 bean能够收到
     * @param bean             队列
     * @param directexchange 交换机
     */
    @Bean
    Binding bindingExchangeBean(Queue bean, DirectExchange directexchange) {
        return BindingBuilder.bind(bean).to(directexchange).with("bean");
    }

}
