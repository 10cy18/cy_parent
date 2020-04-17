package com.cy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import rabbit.RabbitProductApplication;
import rabbit.producer.FanoutProducer;

/**
 * @Author: cy
 * @Date: 2019/2/26 16:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitProductApplication.class)
public class ProductTest {
    @Autowired
    private FanoutProducer fanoutProducer;

    @Test
    public void testSend() {
        fanoutProducer.send();
    }
}
