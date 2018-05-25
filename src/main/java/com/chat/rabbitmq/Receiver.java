package com.chat.rabbitmq;

import com.chat.email.SendEmail;
import com.chat.email.entity.EmailEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * 需要配置监听
 * @Component 用于不清楚是什么类型的类 与 @Service 相似
 */
@Component
public class Receiver {
    @Autowired
    private SendEmail email;
    private static Logger logger = LoggerFactory.getLogger(Receiver.class);
    /**
     * 监听队列 test_springboot
     * @param msg
     * @return
     */
    @RabbitListener(queues = "test_springboot")
    public String processMessage(String msg)throws Exception{
        logger.info(Thread.currentThread().getName() + " 接收到来自test_springboot队列的消息：" + msg);
        EmailEntity entity = new EmailEntity();
        entity.setSubject("欢迎注册xxx");
        entity.setText("欢迎注册xxx欢迎注册xxx欢迎注册xxx欢迎注册xxx欢迎注册xxx欢迎注册xxx欢迎注册xxx");
        entity.setToFrom(msg);
        email.send(entity);
        return msg.toUpperCase();
    }
}
