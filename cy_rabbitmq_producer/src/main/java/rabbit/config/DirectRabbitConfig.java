package rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author chenyong
 * @date 2020/4/15
 **/
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue TestDirectQueue() {
        //true 是否持久
        return new Queue("itcast", true);
    }

    @Bean
    public Queue TestDirectQueue2() {
        //true 是否持久
        return new Queue("chuanzhi", true);
    }

    @Bean
    public Queue TestDirectQueue3() {
        //true 是否持久
        return new Queue("topictest", true);
    }

}