package pl.jbazil.javabase.classis.orm.persistence.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.persistence.entity.CategoryEntity;
import pl.jbazil.javabase.classis.orm.persistence.entity.ProductEntity;
import pl.jbazil.javabase.classis.orm.persistence.repository.CategoryRepository;

@Component
@RequiredArgsConstructor
public class ProductPersistenceMapper implements PersistenceMapper<ProductModel, ProductEntity> {

    private final CategoryRepository categoryRepository;

    @Override
    public ProductEntity modelToEntity(ProductModel model) {
        //be careful - reference is NOT a real entity, just a proxy
        CategoryEntity categoryReference = categoryRepository.getReferenceById(model.categoryId());

        return ProductEntity
                .builder()
                .id(model.id())
                .rating(model.rating())
                .name(model.name())
                .code(model.code())
                .category(categoryReference)
                .build();
    }

    @Override
    public ProductModel entityToModel(ProductEntity entity) {
        return new ProductModel(
                entity.getId(),
                entity.getName(),
                entity.getCode(),
                entity.getRating(),
                entity.getCategory().getId()
        );
    }
}
