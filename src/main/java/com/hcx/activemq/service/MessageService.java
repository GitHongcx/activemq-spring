package com.hcx.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 点对点方式
 * Created by hongcaixia on 2019/7/15.
 */
@Service
public class MessageService {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息
     */
    public void sendMessage(){
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("Hello Spring JMS.");
            }
        });
    }

    /**
     * 接收消息
     * @return
     */
    public String receiveMessage(){

        String text = "";
                //同步接收
        Message message = jmsTemplate.receive();
        if(message instanceof TextMessage){
            try {
                text = ((TextMessage) message).getText();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return text;
    }
}
