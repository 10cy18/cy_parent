package com.cy.rabbit.customer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: cy
 * @Date: 2019/2/26 16:32
 */
@Component
@RabbitListener(queues = "itcast")
public class Customer1 {
    @Value("${server.port}")
    private String serverPort;

    @RabbitHandler
    public void showMessage(String message) {
        System.out.println(serverPort + "直接模式消费消息： itcast接收到消息：" + message);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitHandler
    public void monitoringMethod(byte[] msgByte, Channel channel, Message message) throws IOException {
        Map<String, Object> logMap = new ConcurrentHashMap<>(16);
        try {
            //消息确认
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            //monotoringInsertDB(msgByte,new ConcurrentHashMap<>());
        } catch (Exception e) {
            //失败后消息被确认
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //commonRabbitService.insertLogError(logMap, ERROR_104, e.getMessage());
            System.out.println("mq接收消息失败");
        }
    }

}
