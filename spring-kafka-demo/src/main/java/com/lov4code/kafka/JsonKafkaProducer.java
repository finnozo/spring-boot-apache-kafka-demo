package com.lov4code.kafka;

import com.lov4code.payload.UserPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JsonKafkaProducer {
    private final KafkaTemplate<String, UserPayload> kafkaTemplate;

    public void sendMessage(UserPayload payload) {
        log.info("Message -> {}", payload.toString());
        Message<UserPayload> message =
                MessageBuilder.withPayload(payload)
                        .setHeader(KafkaHeaders.TOPIC, "lov4code_json")
                        .build();
        kafkaTemplate.send(message);
    }
}
