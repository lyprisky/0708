package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveMsgController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @JmsListener(destination = "aaa")

    public void getMsg(String msg){
        System.out.println("接收到的消息是"+msg);
    }
}
