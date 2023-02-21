package com.kai.service1;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer1 {

    // Q:how to make sure a broker dead, and then send message to another broker?
    // A: use replication factor to 3
    // Q: where to set replication factor?
    // A: in the application.properties

    private static final String TOPIC = "test_topic";

    private KafkaTemplate<String, String> kafkaTemplate;

    public Producer1(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        this.kafkaTemplate.send(TOPIC, message);
    }

    // send message with key
    public void sendMessageWithKey(String key, String message) {
        this.kafkaTemplate.send(new ProducerRecord<>(TOPIC, key, message));
    }

    // send message with partition
    public void sendMessageWithPartition(String message, int partition) {
        this.kafkaTemplate.send(new ProducerRecord<>(TOPIC, partition, null, message));
    }

    // send message with key and partition
    public void sendMessageWithKeyAndPartition(String key, String message, int partition) {
        this.kafkaTemplate.send(new ProducerRecord<>(TOPIC, partition, key, message));
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(TOPIC, 2, (short) 1);
    }

}
