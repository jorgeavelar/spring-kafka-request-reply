package coffeeshop.core.services;

import coffeeshop.core.model.Coffee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCoffeeConsumer implements ConsumerListener<Coffee> {
    @Override
    @KafkaListener(topics = "${spring.kafka.request-topic}")
    @SendTo
    public Coffee consume(Coffee coffee) {
        coffee.setId(UUID.randomUUID());
        return coffee;
    }
}
