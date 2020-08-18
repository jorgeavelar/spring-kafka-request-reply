package coffeeshop.web.converters;

import coffeeshop.core.model.Coffee;
import coffeeshop.web.forms.CoffeeForm;
import coffeeshop.web.resources.CoffeeResource;

public class CoffeeConverter {
    private CoffeeForm form;
    private Coffee coffee;

    public CoffeeConverter(CoffeeForm coffeeForm) {
        this.form = coffeeForm;
    }

    public CoffeeConverter(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee convertToCoffee() {
        var coffee = new Coffee();
        coffee.setPrice(this.form.getPrice());
        coffee.setQuantity(this.form.getQuantity());
        coffee.setVarietal(this.form.getVarietal());
        return coffee;
    }

    public CoffeeResource convertToCoffeeResource() {
        return CoffeeResource.builder()
                .id(this.coffee.getId())
                .price(this.coffee.getPrice())
                .quantity(this.coffee.getQuantity())
                .varietal(this.coffee.getVarietal())
                .amount(this.coffee.getAmount())
                .build();
    }
}
