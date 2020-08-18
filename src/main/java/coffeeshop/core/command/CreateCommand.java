package coffeeshop.core.command;

import coffeeshop.core.model.Coffee;

import java.util.concurrent.ExecutionException;

public interface CreateCommand<T> {
    T create(T obj) throws ExecutionException, InterruptedException;
}
