package com.elsoft.kafkaone.producer.config;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaWikimediaProducer {

    @Value("${topic.wikimedia:wikimedia_recent_change}")
    String topicName;

    final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate,topicName );

        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource eventSource = new EventSource.Builder(eventHandler,URI.create(url)).build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(100);
    }
}

