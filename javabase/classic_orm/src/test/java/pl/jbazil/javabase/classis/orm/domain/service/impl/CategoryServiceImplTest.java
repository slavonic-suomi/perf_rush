package pl.jbazil.javabase.classis.orm.domain.service.impl;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.jbazil.javabase.classis.orm.TestClassicOrmApplication;
import pl.jbazil.javabase.classis.orm.domain.model.CategoryModel;
import pl.jbazil.javabase.classis.orm.domain.service.CategoryService;

import java.util.List;

@Log
@SpringBootTest(classes = TestClassicOrmApplication.class)
class CategoryServiceImplTest {
    @Autowired
    CategoryService categoryService;

    @Test
    void testTop() {
        List<CategoryModel> categories = categoryService.findAllWithTopProducts(0, 2, 5);
        log.info("Got data: " + categories);
    }

}