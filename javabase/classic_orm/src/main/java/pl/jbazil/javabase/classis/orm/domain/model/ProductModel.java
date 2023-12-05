package pl.jbazil.javabase.classis.orm.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductModel {
    private final Long id;
    private final String name;
    private final String code; //UUID
    private final BigDecimal rating;
    private final Long categoryId;
}
