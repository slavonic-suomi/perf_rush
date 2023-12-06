package pl.jbazil.javabase.classis.orm.repository;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.jbazil.javabase.classis.orm.TestClassicOrmApplication;
import pl.jbazil.javabase.classis.orm.persistence.entity.CategoryEntity;
import pl.jbazil.javabase.classis.orm.persistence.entity.ProductEntity;
import pl.jbazil.javabase.classis.orm.persistence.repository.CategoryRepository;
import pl.jbazil.javabase.classis.orm.persistence.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log
@SpringBootTest(classes = TestClassicOrmApplication.class)
class ProductRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    void testSave() {
        CategoryEntity category = categoryRepository
                .findAll()
                .stream()
                .findAny()
                .orElseThrow();

        long maxExistingId = productRepository
                .findAll()
                .stream()
                .mapToLong(ProductEntity::getId)
                .max()
                .orElse(0);

        ProductEntity product = productRepository.save(
                ProductEntity.builder()
                        .name("Test product")
                        .code(UUID.randomUUID().toString())
                        .rating(new BigDecimal("4.13"))
                        .category(category)
                        .build()
        );

        assertNotNull(product.getId());
        assertEquals("Test product", product.getName());
        assertEquals(maxExistingId + 1, product.getId());
        assertEquals(category.getId(), product.getCategory().getId());
    }

}