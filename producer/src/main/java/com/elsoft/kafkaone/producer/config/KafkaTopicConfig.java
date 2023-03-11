package com.elsoft.kafkaone.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${topic.wikimedia:wikimedia_recent_change}")
    String wikimediaRecentChange;
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(wikimediaRecentChange).build();
    }
}
