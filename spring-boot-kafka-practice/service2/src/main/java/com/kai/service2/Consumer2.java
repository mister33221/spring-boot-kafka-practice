package com.kai.service2;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer2 {

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consumeMessage(ConsumerRecord<String, String> record) throws InterruptedException {
        System.out.println("Consumer1:  \n topic: " + record.topic() + "\n  partition: " + record.partition() + "\n  offset: " + record.offset() + "\n  key: " + record.key() + "\n  value: " + record.value());

    }

}
