package com.desheng.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.desheng.rabbitmq.config.sender.FirstSender;

//@Controller
public class TestController {

    @Autowired
    private FirstSender firstSender;

    @GetMapping("/send")
    public String send(String message) {
        String uuid = UUID.randomUUID().toString();
        firstSender.send(uuid, message);
        return uuid;
    }
}

