package coffeeshop.core.services;

import coffeeshop.core.model.Coffee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCoffeeConsumer {
	 @KafkaListener(topics = "${spring.kafka.request-topic}")
	 @SendTo
	  public Coffee listen(Coffee coffee) {
	     coffee.setId(UUID.randomUUID());
		 return coffee;
	  }
}
