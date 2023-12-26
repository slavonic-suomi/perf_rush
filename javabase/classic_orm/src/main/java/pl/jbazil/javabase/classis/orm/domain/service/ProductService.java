package pl.jbazil.javabase.classis.orm.domain.service;


import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    ProductModel createRandom(String name, Long categoryId);

    ProductModel updateRating(Long id, BigDecimal rating);

    ProductModel findById(Long id);

    List<ProductModel> findAll(int pageNum, int pageSize);
}
