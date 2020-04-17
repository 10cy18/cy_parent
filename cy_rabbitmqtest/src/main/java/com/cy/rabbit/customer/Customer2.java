package com.cy.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: cy
 * @Date: 2019/2/26 16:55
 */
@Component
@RabbitListener(queues="chuanzhi" )
public class Customer2 {
    @Value("${server.port}")
    private String serverPort;

    @RabbitHandler
    public void showMessage(String message){
        System.out.println(serverPort+"chuanzhi接收到消息："+message);
    }
}
