package ru.gb.example1_seminar12.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.example1_seminar12.configuration.IntegrationConfig;

import java.util.List;
@Controller
public class SendMessage {
    @Autowired
    private ApplicationContext applicationContext;



    public void sendMessageToChannel(String message) {

        MessageChannel inputChannel = applicationContext.getBean("textInputChannel", MessageChannel.class);

        org.springframework.messaging.Message<String> springMessage = MessageBuilder.withPayload(message).build();

        inputChannel.send(springMessage);
    }




}
