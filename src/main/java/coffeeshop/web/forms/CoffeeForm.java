package coffeeshop.web.forms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Data
public class CoffeeForm {
    private BigDecimal price;
    private String varietal;
    private Integer quantity;

    @JsonCreator
    @Builder
    public CoffeeForm(@JsonProperty("price") BigDecimal price,
                       @JsonProperty("varietal") String varietal,
                       @JsonProperty("quantity") Integer quantity) {
        this.price = price;
        this.varietal = varietal;
        this.quantity = quantity;
    }
}
