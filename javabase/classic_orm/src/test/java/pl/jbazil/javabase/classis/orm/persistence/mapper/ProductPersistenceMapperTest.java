package pl.jbazil.javabase.classis.orm.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.persistence.entity.CategoryEntity;
import pl.jbazil.javabase.classis.orm.persistence.entity.ProductEntity;
import pl.jbazil.javabase.classis.orm.persistence.repository.CategoryRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductPersistenceMapperTest {

    CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
    ProductPersistenceMapper mapper = new ProductPersistenceMapper(categoryRepository);

    @Test
    public void modelToEntityTest() {
        ProductModel model = new ProductModel(1L, "Product 1", "Code 1", new BigDecimal("4.5"), 10L);

        CategoryEntity category = new CategoryEntity();
        category.setId(10L);
        when(categoryRepository.getReferenceById(10L)).thenReturn(category);

        ProductEntity entity = mapper.modelToEntity(model);

        assertEquals(model.id(), entity.getId());
        assertEquals(model.name(), entity.getName());
        assertEquals(model.code(), entity.getCode());
        assertEquals(model.rating(), entity.getRating());
        assertEquals(model.categoryId(), entity.getCategory().getId());

    }
}