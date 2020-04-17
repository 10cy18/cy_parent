package rabbit.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cy
 * @Date: 2019/2/26 16:26
 */
@RestController
public class ProductTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/t")
    public void testSend() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("itcast", "直接模式测试-我要红包-----" + i);
        }
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
