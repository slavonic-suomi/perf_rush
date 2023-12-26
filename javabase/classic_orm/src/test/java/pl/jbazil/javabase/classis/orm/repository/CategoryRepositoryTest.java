package pl.jbazil.javabase.classis.orm.repository;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.jbazil.javabase.classis.orm.TestClassicOrmApplication;
import pl.jbazil.javabase.classis.orm.persistence.entity.CategoryEntity;
import pl.jbazil.javabase.classis.orm.persistence.repository.CategoryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log
@SpringBootTest(classes = TestClassicOrmApplication.class)
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @Order(1)
    void testFindAll() {
        List<CategoryEntity> all = categoryRepository.findAll();
        log.info("Found existing data: " + all);

        assertEquals(4, all.size()); //from flyway 'test data' script
    }

    @Test
    @Order(2)
    void testSave() {
        long maxExistingId = categoryRepository
                .findAll()
                .stream()
                .mapToLong(CategoryEntity::getId)
                .max()
                .orElse(0);

        log.info("Max existing category id: " + maxExistingId);
        CategoryEntity entity = categoryRepository.save(CategoryEntity.builder().name("testSave").build());

        assertNotNull(entity.getId());
        assertEquals("testSave", entity.getName());
        assertEquals(maxExistingId + 1, entity.getId());
    }
}
