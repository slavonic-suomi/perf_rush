package pl.jbazil.javabase.classis.orm.web.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateProductRatingRequest {
    @JsonProperty("rating")
    private String rating;
}
