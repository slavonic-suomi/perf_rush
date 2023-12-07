package pl.jbazil.javabase.classis.orm.domain.model;


import java.math.BigDecimal;

public record ProductModel(
        Long id,
        String name,
        String code,
        BigDecimal rating,
        Long categoryId) {
}
