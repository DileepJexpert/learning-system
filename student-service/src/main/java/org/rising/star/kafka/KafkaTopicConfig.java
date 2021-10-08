package org.rising.star.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

//@Configuration
public class KafkaTopicConfig {

	@Value("${myapp.kafka.topic1}")
	private String topic1;

	@Value("${myapp.kafka.topic2}")
	private String topic2;
	
	@Value("${myapp.kafka.topic3}")
	private String topic3;
	
	@Value("${myapp.kafka.topic4}")
	private String topic4;

	@Bean
	NewTopic topic1() {
		return TopicBuilder.name(topic1).build();
	}

	@Bean
	NewTopic topic2() {
		return TopicBuilder.name(topic2).build();
	}
	
	@Bean
	NewTopic topic3() {
		return TopicBuilder.name(topic3).build();
	}
	
	@Bean
	NewTopic topicUser() {
		return TopicBuilder.name(topic4).build();
	}
	
	@Bean
	NewTopic topicBytes() {
		return TopicBuilder.name("reflectoring-bytes").build();
	}
	
	@Bean
	NewTopic others() {
		return TopicBuilder.name("reflectoring-others").build();
	}
	
	@Bean
	  public NewTopic topicExample() {
	    return TopicBuilder.name("my-first-kafka-topic")
	      .partitions(6)
	      .replicas(3)
	      .build();
	  }
	
	@Bean
	  public NewTopic compactTopicExample() {
	    return TopicBuilder.name("my-first-compact-kafka-topic")
	      .partitions(6)
	      .replicas(3)
	      .compact()
	      .build();
	  }
	
		/*
		 * @Bean public NewTopic topicWithCompressionExample() { return
		 * TopicBuilder.name("kafka-topic-with-compression") .partitions(6) .replicas(3)
		 * .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd") .build(); }
		 */
}