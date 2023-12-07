package pl.jbazil.javabase.classis.orm.persistence.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.jbazil.javabase.classis.orm.domain.model.CategoryModel;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.persistence.entity.CategoryEntity;
import pl.jbazil.javabase.classis.orm.persistence.entity.ProductEntity;

@Component
@RequiredArgsConstructor
public class CategoryMapper implements PersistenceMapper<CategoryModel, CategoryEntity> {

    private final PersistenceMapper<ProductModel, ProductEntity> productMapper;

    @Override
    public CategoryEntity modelToEntity(CategoryModel model) {
        return CategoryEntity
                .builder()
                .id(model.id())
                .name(model.name())
                .build();
    }

    @Override
    public CategoryModel entityToModel(CategoryEntity entity) {
        return new CategoryModel(
                entity.getId(),
                entity.getName(),
                entity.getProducts().stream().map(productMapper::entityToModel).toList()
        );
    }
}
