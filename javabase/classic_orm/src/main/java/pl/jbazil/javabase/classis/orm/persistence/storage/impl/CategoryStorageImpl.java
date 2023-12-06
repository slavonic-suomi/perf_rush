package pl.jbazil.javabase.classis.orm.persistence.storage.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jbazil.javabase.classis.orm.domain.model.CategoryModel;
import pl.jbazil.javabase.classis.orm.domain.storage.CategoryStorage;
import pl.jbazil.javabase.classis.orm.persistence.entity.CategoryEntity;
import pl.jbazil.javabase.classis.orm.persistence.entity.ProductEntity;
import pl.jbazil.javabase.classis.orm.persistence.mapper.PersistenceMapper;
import pl.jbazil.javabase.classis.orm.persistence.repository.CategoryRepository;
import pl.jbazil.javabase.classis.orm.persistence.repository.ProductRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class CategoryStorageImpl implements CategoryStorage {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final PersistenceMapper<CategoryModel, CategoryEntity> categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryModel> findAllWithTopProducts(int pageNum, int pageSize, int topProductsCount) {
        List<CategoryEntity> categories = categoryRepository.findAll(PageRequest.of(pageNum, pageSize)).getContent();
        categories.forEach(category -> {
            List<ProductEntity> products = productRepository.findAllByCategoryIdOrderByRatingDesc(category.getId(), Pageable.ofSize(topProductsCount));
            category.setProducts(products);
        });

        return categories.stream().map(categoryMapper::entityToModel).toList();
    }
}
