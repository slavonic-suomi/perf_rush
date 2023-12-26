package pl.jbazil.javabase.classis.orm.web.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateRandomProductRequest {
        @JsonProperty("name")
        private final String name;
        @JsonProperty("categoryId")
        private final Long categoryId;
}
