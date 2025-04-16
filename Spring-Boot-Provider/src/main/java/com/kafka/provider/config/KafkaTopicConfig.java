package com.kafka.provider.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    
    @Bean
    public NewTopic createTopic() {

        Map<String, String> config = new HashMap<>();
        config.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        config.put(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(24 * 60 * 60 * 1000)); // 1 day
        config.put(TopicConfig.SEGMENT_BYTES_CONFIG, String.valueOf(1024 * 1024 * 1024)); // 1 GB
        config.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, String.valueOf(1024 * 1024)); // 1 MB

        return TopicBuilder.name("my-topic")
                .partitions(2) // Number of partitions
                .replicas(2) // Number of replicas
                .configs(config) // Topic configuration
                .build();
    }
}
