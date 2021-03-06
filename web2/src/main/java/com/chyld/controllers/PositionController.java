package com.chyld.controllers;

import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/positions")
public class PositionController {
    private DeviceService service;
    private RabbitTemplate rabbitTemplate;
    private TopicExchange topicExchange;

    @Autowired
    public void setService(DeviceService service) {
        this.service = service;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {this.rabbitTemplate = rabbitTemplate;}

    @Autowired
    public void setTopicExchange(TopicExchange topicExchange) {this.topicExchange = topicExchange;}

    @RequestMapping(value = "/{serial}", method = RequestMethod.POST)
    public Position addPosition(@PathVariable String serial, @RequestBody Position position) {
        String topicName = topicExchange.getName();
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("serial", serial);
        hm.put("position", position);
        rabbitTemplate.convertAndSend(topicName, "fit.topic.pos", hm);
        return null;
    }
}