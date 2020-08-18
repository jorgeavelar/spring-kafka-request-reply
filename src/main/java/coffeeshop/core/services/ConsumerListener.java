package coffeeshop.core.services;

import coffeeshop.core.model.Coffee;

public interface ConsumerListener<T> {
    T consume(T obj);
}
