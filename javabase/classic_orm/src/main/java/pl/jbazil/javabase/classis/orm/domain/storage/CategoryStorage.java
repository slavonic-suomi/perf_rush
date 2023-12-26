package pl.jbazil.javabase.classis.orm.domain.storage;


import pl.jbazil.javabase.classis.orm.domain.model.CategoryModel;

import java.util.List;

public interface CategoryStorage {
    List<CategoryModel> findAllWithTopProducts(int pageNum, int pageSize, int topProductsCount);

    CategoryModel create(String name);
}
