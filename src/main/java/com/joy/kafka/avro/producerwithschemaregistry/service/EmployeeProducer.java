package com.joy.kafka.avro.producerwithschemaregistry.service;

import lombok.extern.slf4j.Slf4j;
import model.schema.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeProducer {

    private final KafkaTemplate<String, Employee> kafkaTemplate;

    @Autowired
    public EmployeeProducer(KafkaTemplate<String,Employee> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void saveEmployee(Employee e){
        this.kafkaTemplate.send("employee",e.getEmployeeId(),e);
        log.info(String.format("Produced Employee -> %s", e));
    }
}
