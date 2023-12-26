package pl.jbazil.javabase.classis.orm.domain.storage;


import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductStorage {
    ProductModel create(ProductModel product);

    ProductModel findById(Long id);

    ProductModel updateRating(Long id, BigDecimal rating);

    List<ProductModel> findAll(int pageNum, int pageSize);
}
