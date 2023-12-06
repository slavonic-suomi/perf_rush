package pl.jbazil.javabase.classis.orm.domain.service;


import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel createRandom(String name, Long categoryId);

    List<ProductModel> findAll(int pageNum, int pageSize);
}
