package pl.jbazil.javabase.classis.orm.domain.storage;


import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;

import java.util.List;

public interface ProductStorage {
    ProductModel save(ProductModel product);

    List<ProductModel> findAll(int pageNum, int pageSize);
}
