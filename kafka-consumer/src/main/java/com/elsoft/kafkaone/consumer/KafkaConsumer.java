package com.elsoft.kafkaone.consumer;

import com.elsoft.kafkaone.consumer.entities.WikimediaData;
import com.elsoft.kafkaone.consumer.repo.WikimediaDataRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    final WikimediaDataRepository wikimediaDataRepository;
    @KafkaListener(topics = "${topic.wikimedia:wikimedia_recent_change}",
            groupId = "myGroup" )
    public void consumer(String eventMessage){
        log.info(String.format("Event Message Received -> %s", eventMessage));
        WikimediaData data = new WikimediaData();
        data.setWikiEventData(eventMessage);

        wikimediaDataRepository.save(data);
    }
}
