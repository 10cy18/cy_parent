package com.cy.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 消费者
 *
 * @author chenyong
 * @date 2020/4/16
 **/
@Component
public class HelloReceiver {

    @RabbitListener(queues = "topic.message")
    public void process(String str) {
        System.out.println("ReceiverA  : " + str);
    }

    @RabbitListener(queues = "topic.message")
    public void process2(String str) {
        System.out.println("ReceiverB  : " + str);
    }

    @RabbitListener(queues = "queue")
    public void process1(String str) {
        System.out.println("Receiver  : " + str);
    }

    @RabbitListener(queues = "fanout.A")
    public void process3(String str) {
        System.out.println("ReceiverA  : " + str);
    }

    @RabbitListener(queues = "fanout.B")
    public void process4(String str) {
        System.out.println("ReceiverB  : " + str);
    }

    @RabbitListener(queues = "fanout.C")
    public void process5(String str) {
        System.out.println("ReceiverC  : " + str);
    }

}