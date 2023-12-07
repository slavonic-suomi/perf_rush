package pl.jbazil.javabase.classis.orm.domain.model;

import java.util.List;


public record CategoryModel(
        Long id,
        String name,
        List<ProductModel> products) {
}
