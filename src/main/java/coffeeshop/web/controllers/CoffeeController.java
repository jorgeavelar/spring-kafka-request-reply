package coffeeshop.web.controllers;

import coffeeshop.core.command.CreateCommand;
import coffeeshop.core.model.Coffee;
import coffeeshop.web.converters.CoffeeConverter;
import coffeeshop.web.forms.CoffeeForm;
import coffeeshop.web.resources.CoffeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RequestMapping
@RestController
public class CoffeeController {

    @Autowired
    private CreateCommand<Coffee> coffeeCreate;

    @ResponseBody
    @PostMapping(value = "/coffee/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CoffeeResource create(@RequestBody CoffeeForm form) throws ExecutionException, InterruptedException {
        var coffee = new CoffeeConverter(form)
                .convertToCoffee();

        var resource = new CoffeeConverter(coffeeCreate.create(coffee))
                .convertToCoffeeResource();
        return resource;
    }
}
