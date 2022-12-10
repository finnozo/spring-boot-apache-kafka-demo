package com.lov4code.kafka;

import com.lov4code.payload.UserPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics = "lov4code_json", groupId = "myGroup")
    public void consume(UserPayload payload) {
        log.info("Massage received -> {}", payload);
    }
}
