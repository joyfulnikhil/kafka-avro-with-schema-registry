package com.joy.kafka.avro.producerwithschemaregistry.controller;

import com.joy.kafka.avro.producerwithschemaregistry.service.EmployeeProducer;
import com.joy.kafka.avro.producerwithschemaregistry.service.Producer;
import model.schema.Employee;
import model.schema.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class KafkaController {



    private final Producer producer;
    private final EmployeeProducer employeeProducer;

    @Autowired
    KafkaController(Producer producer,EmployeeProducer employeeProducer) {
        this.producer = producer;
        this.employeeProducer=employeeProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        this.producer.sendMessage(new User(name, age));
    }

   @PostMapping(value = "/employee")
    public void sendMessageToKafkaTopic(@RequestBody Employee employee) {
        this.employeeProducer.saveEmployee(employee);
    }
}
