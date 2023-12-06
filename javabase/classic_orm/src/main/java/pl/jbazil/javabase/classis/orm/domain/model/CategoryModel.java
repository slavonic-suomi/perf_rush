package pl.jbazil.javabase.classis.orm.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CategoryModel {
    private final Long id;
    private final String name;
    private final List<ProductModel> products;
}
