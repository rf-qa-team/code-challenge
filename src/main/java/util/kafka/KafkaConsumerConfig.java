package util.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;


import java.time.Duration;
import java.util.*;

import static params.KafkaParams.CLIENT_ID;
import static params.KafkaParams.KAFKA_POLL_TIMEOUT;

/**
 * kafka consumer client.
 */

public final class KafkaConsumerConfig {

    private KafkaConsumerConfig() {
    }

    /**
     * kafka configuration.
     *
     * @param addr - kafka sever address. Example: "localhost:9290"
     * @return kafka consumer obj.
     */
    private static KafkaConsumer consumerFactory(String addr) {
        Properties props = new Properties();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                addr);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, CLIENT_ID);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_DOC, "latest");
        return new KafkaConsumer<>(props);
    }

    /**
     * get records from kafka for specific topic in List String.
     *
     * @param addr  - kafka sever address. Example: "localhost:9290".
     * @param topic - string topic name.
     * @return all values fro specific topic.
     */
    public static List<String> getRecordsFromKafka(String addr, String topic) {
        KafkaConsumer ks = consumerFactory(addr);
        TopicPartition topicPartition = new TopicPartition(topic, 0);
        ks.assign(Collections.singleton(topicPartition));
        ks.seekToBeginning(Collections.singleton(topicPartition));
        ConsumerRecords<String, String> records = ks.poll(Duration.ofMillis(KAFKA_POLL_TIMEOUT));
        List<String> list = new ArrayList<>();
        records.forEach(record -> list.add(record.value()));
        return list;
    }
}