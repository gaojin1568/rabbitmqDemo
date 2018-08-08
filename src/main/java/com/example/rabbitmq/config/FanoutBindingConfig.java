package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout:广播订阅,向所有的消费者发布消息 配置中心
 * @author gaojin
 */
@Configuration
public class FanoutBindingConfig {

    /**
     * 声明Fanout的fanout.A队列
     */
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    /**
     * 声明Fanout的fanout.B队列
     */
    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    /**
     * 声明Fanout的fanout.C队列
     */
    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    /**
     * 声明fanoutExchange交换机
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 绑定fanoutExchange和AMessage
     * @param AMessage             队列
     * @param fanoutExchange 交换机
     */
    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    /**
     * 绑定fanoutExchange和BMessage
     * @param BMessage             队列
     * @param fanoutExchange 交换机
     */
    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    /**
     * 绑定fanoutExchange和CMessage
     * @param CMessage             队列
     * @param fanoutExchange 交换机
     */
    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
