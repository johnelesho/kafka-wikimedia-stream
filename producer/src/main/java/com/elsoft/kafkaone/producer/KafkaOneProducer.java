package com.elsoft.kafkaone.producer;

import com.elsoft.kafkaone.producer.config.KafkaWikimediaProducer;
import com.elsoft.kafkaone.producer.config.WikimediaChangesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaOneProducer {
    public static void main(String[] args) {
        SpringApplication.run(KafkaOneProducer.class);
    }

    @Autowired
    KafkaWikimediaProducer producer;
    @Bean
    public CommandLineRunner load(){

        return args -> producer.sendMessage();
    }
}
