package com.kai.service1;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    private final Producer1 producer;

    private KafkaTemplate<String, String> kafkaTemplate;

    public Controller(Producer1 producer, KafkaTemplate<String, String> kafkaTemplate) {
        this.producer = producer;
        this.kafkaTemplate = kafkaTemplate;
    }

    // If you did't set the key or partition, the message will be sent to the random partition
    @GetMapping("/sendMessage")
    public void messageToTopic(@RequestParam("message") String message) throws InterruptedException {
        System.out.println("send message");
        for (int i = 0; i < 100; i++) {
            this.producer.sendMessage(message + i);
//            Thread.sleep(500);
        }
    }

    // If you set the key, the message will be sent to the same partition
    // we usually use the key to identify the message, because the key will be hashed to a partition
    @GetMapping("/sendMessageWithKey")
    public void messageToTopicWithKey(@RequestParam("key") String key, @RequestParam("message") String message) {
        for (int i = 0; i < 10; i++) {
            this.producer.sendMessageWithKey(key, message + i);
        }
    }

    // If you set the partition, the message will be sent to the same partition
    @GetMapping("/sendMessageWithPartition")
    public void messageToTopicWithPartition(@RequestParam("message") String message, @RequestParam("partition") int partition) throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            this.producer.sendMessageWithPartition(message + i, partition);
            Thread.sleep(500);
        }
    }

    // If you set the key and partition, the message will be sent to the same partition
    @GetMapping("/sendMessageWithKeyAndPartition")
    public void messageToTopicWithKeyAndPartition(@RequestParam("key") String key, @RequestParam("message") String message, @RequestParam("partition") int partition) {
        for (int i = 0; i < 10; i++) {
            this.producer.sendMessageWithKeyAndPartition(key, message + i, partition);
        }
    }


}
