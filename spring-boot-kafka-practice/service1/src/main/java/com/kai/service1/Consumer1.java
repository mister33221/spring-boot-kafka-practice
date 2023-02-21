package com.kai.service1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer1 {

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consumeMessage(ConsumerRecord<String, String> record) throws InterruptedException {
//        if(record.value().equals("hi90")){
//            throw new RuntimeException("hi90");
//        }
        System.out.println("Consumer1:  \n topic: " + record.topic() + "\n  partition: " + record.partition() + "\n  offset: " + record.offset() + "\n  key: " + record.key() + "\n  value: " + record.value());
    }

}
