package com.example.kafka.message;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;

import java.util.Map;

/**
 * @author 江南
 * @usage
 * @reviewer
 * @since 2017/4/5
 */
public class SimpleKafkaMessage {

    public static <T> GenericMessage newMessage(T msg, String topic){
        Map<String,Object> messageHeader = Maps.newHashMap();
        messageHeader.put(KafkaHeaders.TOPIC,topic);
        return new GenericMessage(JSON.toJSONString(msg),messageHeader);
    }

    public static <T> GenericMessage newMessage(T msg, String topic,Integer partionId,String messageKey){
        Map<String,Object> messageHeader = Maps.newHashMap();
        messageHeader.put(KafkaHeaders.TOPIC,topic);
        messageHeader.put(KafkaHeaders.PARTITION_ID,partionId);
        messageHeader.put(KafkaHeaders.MESSAGE_KEY,messageKey);
        return new GenericMessage(msg,messageHeader);
    }

}
