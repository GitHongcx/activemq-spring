package com.hcx.activemq;

import com.hcx.activemq.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hongcaixia on 2019/7/15.
 */
public class MyTest2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MessageService messageService = context.getBean("messageService", MessageService.class);
//        messageService.sendMessage();
        String text = messageService.receiveMessage();
        System.out.println(text);
    }
}
