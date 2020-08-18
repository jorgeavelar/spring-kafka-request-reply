package coffeeshop.core.command;

import coffeeshop.core.model.Coffee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class CoffeeCreated implements CreateCommand<Coffee> {

    @Autowired
    private ReplyingKafkaTemplate<String, Coffee, Coffee> replyingKafkaTemplate;

    @Value("${spring.kafka.request-topic}")
    String requestTopic;

    @Value("${spring.kafka.request-reply-topic}")
    String requestReplyTopic;

    private RequestReplyFuture<String, Coffee, Coffee> requestReplyFuture;
    private ConsumerRecord<String, Coffee> consumerRecord;

    @Override
    public Coffee create(Coffee coffee) throws ExecutionException, InterruptedException {
        ProducerRecord<String, Coffee> record = new ProducerRecord<String, Coffee>(requestTopic, coffee);
        record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, requestReplyTopic.getBytes()));
        requestReplyFuture = replyingKafkaTemplate.sendAndReceive(record);
        consumerRecord = requestReplyFuture.get();
        return consumerRecord.value();
    }
}
