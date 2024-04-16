package com.baraniok.kafkaretryable;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class KafkaRetryableApplication implements ApplicationRunner {

    @Resource
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(KafkaRetryableApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        kafkaTemplate.send("first-topic", "1".getBytes(StandardCharsets.UTF_8));
    }
}
