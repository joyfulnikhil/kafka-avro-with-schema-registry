package com.joy.kafka.avro.producerwithschemaregistry.service;

import model.schema.Employee;
import model.schema.User;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {

    @Value("${topic.name}")
    private String topic;
    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        this.kafkaTemplate.send(this.topic, user.getName(), user);
        log.info(String.format("Produced user -> %s", user));
    }

}


