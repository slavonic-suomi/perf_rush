package pl.jbazil.javabase.classis.orm.web.model.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateCategoryRequest {
    @JsonProperty("name")
    private final String name;
}
