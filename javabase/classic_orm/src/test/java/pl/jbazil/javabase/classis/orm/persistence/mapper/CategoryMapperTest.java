package pl.jbazil.javabase.classis.orm.persistence.mapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.mockito.Mockito;
import pl.jbazil.javabase.classis.orm.domain.model.CategoryModel;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.persistence.entity.CategoryEntity;
import pl.jbazil.javabase.classis.orm.persistence.entity.ProductEntity;

import java.util.Collections;

public class CategoryMapperTest {

    private final PersistenceMapper<ProductModel, ProductEntity> productMapper = Mockito.mock();
    private final CategoryMapper categoryMapper = new CategoryMapper(productMapper);

    @Test
    public void modelToEntity_ValidInput_ShouldReturnExpected() {
        // Arrange
        CategoryModel model = new CategoryModel(1L, "Electronics", Collections.emptyList());

        // Act
        CategoryEntity entity = categoryMapper.modelToEntity(model);

        // Assert
        assertEquals(model.id(), entity.getId(), "Id should be equal");
        assertEquals(model.name(), entity.getName(), "Name should be equal");
    }

    @Test
    public void entityToModel_ValidInput_ShouldReturnExpected() {
        // Arrange
        CategoryEntity entity = new CategoryEntity();
        entity.setId(1L);
        entity.setName("Electronics");
        entity.setProducts(Collections.emptyList());

        // Act
        CategoryModel model = categoryMapper.entityToModel(entity);

        // Assert
        assertEquals(entity.getId(), model.id(), "Id should be equal");
        assertEquals(entity.getName(), model.name(), "Name should be equal");
        assertTrue(model.products().isEmpty(), "Products should be empty");
    }

}