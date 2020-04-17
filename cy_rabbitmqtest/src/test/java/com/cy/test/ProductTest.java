package com.cy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.rabbit.RabbitApplication;

/**
 * @Author: cy
 * @Date: 2019/2/26 16:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=RabbitApplication.class)
public class ProductTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend("itcast","直接模式测试-我要红包");
    }
/*

    @Test
    public void testSendFanout(){
        rabbitTemplate.convertAndSend("chuanzhi", "分列模式走起");
    }

    @Test
    public void testSendTopic1(){
        rabbitTemplate.convertAndSend("topictest","主题模式");
    }
*/

/*    @Test
    public void testSendTopic2(){
        rabbitTemplate.convertAndSend("topictest","主题模式");
    }

    @Test
    public void testSendTopic3(){
        rabbitTemplate.convertAndSend("topictest","主题模式");
    }*/
}
