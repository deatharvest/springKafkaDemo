package com.example.kafka;

import com.example.kafka.message.ExampleMessage;
import com.example.kafka.message.SimpleKafkaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleKafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @RequestMapping(value = "/produceKafkaMessage")
    @ResponseBody
    public String sendKafkaMessage(ExampleMessage exampleMessage) {
        kafkaProducer.sendMessage(SimpleKafkaMessage.newMessage(exampleMessage,"helloworld.kafka.Topic"));
        return "Successfully Produced Message to Kafka Topic";
    }
}
