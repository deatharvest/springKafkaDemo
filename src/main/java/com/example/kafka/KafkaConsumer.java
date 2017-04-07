package com.example.kafka;

import com.alibaba.fastjson.JSON;
import com.example.kafka.message.ExampleMessage;
import com.example.kafka.message.SimpleKafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "helloworld.kafka.Topic")
    public void receiveMessage(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }

    @KafkaListener(id="batch", topics = "helloworld.kafka.Topic",containerFactory = "batchFactory")
    public void batchReceiveMessage(List<Message<?>> list) {
        LOGGER.info("----------------->batch received message size='{}'", list.size());
        ExampleMessage exampleMessage = JSON.parseObject(list.get(0).getPayload().toString(),ExampleMessage.class);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
