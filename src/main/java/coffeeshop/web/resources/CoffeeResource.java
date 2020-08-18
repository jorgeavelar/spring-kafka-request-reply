package coffeeshop.web.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoffeeResource {
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
}
