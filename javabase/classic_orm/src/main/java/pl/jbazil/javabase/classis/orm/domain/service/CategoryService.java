package pl.jbazil.javabase.classis.orm.domain.service;


import pl.jbazil.javabase.classis.orm.domain.model.CategoryModel;

import java.util.List;


public interface CategoryService {
    List<CategoryModel> findAllWithTopProducts(int pageNum, int pageSize, int topProductsCount);

    CategoryModel create(String name);
}
