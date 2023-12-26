package pl.jbazil.javabase.classis.orm.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jbazil.javabase.classis.orm.domain.model.CategoryModel;
import pl.jbazil.javabase.classis.orm.domain.service.CategoryService;
import pl.jbazil.javabase.classis.orm.domain.storage.CategoryStorage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryStorage categoryStorage;

    @Override
    public List<CategoryModel> findAllWithTopProducts(int pageNum, int pageSize, int topProductsCount) {
        return categoryStorage.findAllWithTopProducts(pageNum, pageSize, topProductsCount);
    }

    @Override
    public CategoryModel create(String name) {
        return categoryStorage.create(name);
    }
}
