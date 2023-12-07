package pl.jbazil.javabase.classis.orm.domain.service.impl;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.jbazil.javabase.classis.orm.TestClassicOrmApplication;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.domain.service.ProductService;

import static org.junit.jupiter.api.Assertions.*;

@Log
@SpringBootTest(classes = TestClassicOrmApplication.class)
class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    void createRandom() {
        ProductModel testProduct = productService.createRandom("Test random product", 1L);

        assertNotNull(testProduct);
        assertNotNull(testProduct.id());
        log.info("Created product: " + testProduct);
    }
}