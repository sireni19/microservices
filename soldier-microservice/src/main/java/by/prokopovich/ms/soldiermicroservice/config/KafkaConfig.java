//package by.prokopovich.ms.soldiermicroservice.config;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//import java.util.Map;
//
//@Configuration
//public class KafkaConfig {
//
//    @Bean
//    NewTopic createTopic(){
//    return TopicBuilder.name("soldier-weapon-event-topic")
//            .partitions(2)//топик содержит 2 партиции, которые могут быть на любых брокерах
//            .replicas(1)
//            .configs(Map.of("min.insync.replicas","1"))
//            .build();
//}
//}
