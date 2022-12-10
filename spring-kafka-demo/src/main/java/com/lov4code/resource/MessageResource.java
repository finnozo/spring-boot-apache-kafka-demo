package com.lov4code.resource;

import com.lov4code.kafka.JsonKafkaProducer;
import com.lov4code.kafka.KafkaProducer;
import com.lov4code.payload.UserPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
@RequiredArgsConstructor
public class MessageResource {
    private final KafkaProducer kafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message send to the topic");
    }

    @PostMapping("publish")
    public ResponseEntity<String> publishJsonObject(@RequestBody UserPayload payload) {
        jsonKafkaProducer.sendMessage(payload);
        return ResponseEntity.ok("Json Message send to kafka topic successfully!");
    }
}
