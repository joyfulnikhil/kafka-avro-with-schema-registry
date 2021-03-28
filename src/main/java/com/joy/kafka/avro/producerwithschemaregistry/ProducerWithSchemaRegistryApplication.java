package com.joy.kafka.avro.producerwithschemaregistry;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerWithSchemaRegistryApplication {

    @Value("${topic.name}")
    private String topicName;
    @Value("${topic.partitions}")
    private Integer partitions;
    @Value("${topic.replication-factor}")
    private short replicationFactor;

    @Bean
    NewTopic userTopic(){
        return new NewTopic(topicName,partitions,replicationFactor);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerWithSchemaRegistryApplication.class, args);
    }

}
