package pl.jbazil.javabase.classis.orm.persistence.storage.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.domain.storage.ProductStorage;
import pl.jbazil.javabase.classis.orm.persistence.entity.ProductEntity;
import pl.jbazil.javabase.classis.orm.persistence.mapper.PersistenceMapper;
import pl.jbazil.javabase.classis.orm.persistence.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class ProductStorageImpl implements ProductStorage {

    private final ProductRepository productRepository;
    private final PersistenceMapper<ProductModel, ProductEntity> mapper;

    @Override
    public ProductModel create(ProductModel product) {
        ProductEntity entity = mapper.modelToEntity(product);
        entity = productRepository.save(entity);
        return mapper.entityToModel(entity);
    }

    @Override
    public ProductModel updateRating(Long id, BigDecimal rating) {
        ProductEntity entity = productRepository.findById(id).orElseThrow();
        entity.setRating(rating);
        productRepository.save(entity);
        return mapper.entityToModel(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductModel> findAll(int pageNum, int pageSize) {
        Page<ProductEntity> entities = productRepository.findAll(PageRequest.of(pageNum, pageSize));
        return entities
                .stream()
                .map(mapper::entityToModel)
                .toList();
    }

    @Override
    public ProductModel findById(Long id) {
        ProductEntity entity = productRepository.findById(id).orElseThrow();
        return mapper.entityToModel(entity);
    }
}
