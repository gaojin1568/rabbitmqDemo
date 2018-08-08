package com.example.rabbitmq.web;

import com.example.rabbitmq.entity.Page;
import com.example.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 以发送请求的方式测试
 * @author gaojin
 */
@RestController
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * http://localhost:8080/sendQ?message=aaa
     * @param message
     */
    @RequestMapping("/sendQ")
    public String sendMQto(String message) {
        int i = 1;
        rabbitTemplate.convertAndSend("directexchange","orange", message);
        rabbitTemplate.convertAndSend("directexchange","orange", message + i++);
        rabbitTemplate.convertAndSend("directexchange","orange", message + i++);
        rabbitTemplate.convertAndSend("directexchange","orange", message + i++);
        rabbitTemplate.convertAndSend("directexchange","orange", message + i++);
        return "SUCCESS";
    }

    /**
     * 测试direct
     * http://localhost:8080/sendQ2?message=bbb
     * @param message
     */
    @RequestMapping("/sendQ2")
    public String sendMQ2to(String message) {
        rabbitTemplate.convertAndSend("directexchange","green", message);
        return "SUCCESS";
    }

    /**
     * 测试类
     * http://localhost:8080/send/user
     */
    @RequestMapping("/send/user")
    public String sendUser() {
        User user = new User();
        Page page = new Page();
        page.setPageNum(1);
        page.setPageName("san");
        page.setPageSize("2");
        user.setPage(page);
        user.setId(1);
        user.setUsername("yanggm");
        user.setPassword("123456");
        rabbitTemplate.convertAndSend("directexchange","bean", user);
        return "SUCCESS";
    }

    /**
     * 测试topic
     * http://localhost:8080/send/topicTest
     */
    @RequestMapping("/send/topicTest")
    public String sendTopic() {
        this.rabbitTemplate.convertAndSend("topicexchange", "t.fee", "green");
        this.rabbitTemplate.convertAndSend("topicexchange", "t.www", "fee");
        return "SUCCESS";
    }

    /**
     * 测试Fanout
     * http://localhost:8080/send/fanoutTest?message=高兴
     */
    @RequestMapping("/send/fanoutTest")
    public String send(String message) {
        this.rabbitTemplate.convertAndSend("fanoutExchange","", message);
        return "SUCCESS";
    }

}