package com.lov4code.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic lov4CodeTopic() {
        return TopicBuilder
                .name("lov4code")
                .partitions(10)
                .build();
    }

    @Bean
    public NewTopic lov4CodeTopicJson() {
        return TopicBuilder
                .name("lov4code_json")
                .partitions(10)
                .build();
    }
}
