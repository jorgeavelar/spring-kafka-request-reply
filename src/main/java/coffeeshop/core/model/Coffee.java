
package coffeeshop.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coffee {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("varietal")
    private String varietal;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("amount")
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}