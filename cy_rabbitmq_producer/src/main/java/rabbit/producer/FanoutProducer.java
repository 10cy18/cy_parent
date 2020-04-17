package rabbit.producer;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenyong
 * @date 2020/4/16
 **/
@Component
public class FanoutProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
//        User user=new User();    //实现Serializable接口
//        user.setName("Lucy");
//        user.setPassword("123");
//        //1、使用JSONObject
//        String jsonUser = JSONObject.toJSONString(user);
        // direct类型
        rabbitTemplate.convertAndSend("queue", "queue,Hello,Rabbit!");
        //topic类
        rabbitTemplate.convertAndSend("exchange", "topic.message", "exchange,Hello,Rabbit!");
        //fanout类型
        rabbitTemplate.convertAndSend("fanoutExchange", "", "fanoutExchange,Hello,Rabbit!");
    }
}