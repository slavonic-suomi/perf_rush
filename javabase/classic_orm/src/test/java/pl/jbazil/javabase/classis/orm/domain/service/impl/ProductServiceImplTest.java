package pl.jbazil.javabase.classis.orm.domain.service.impl;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.jbazil.javabase.classis.orm.TestClassicOrmApplication;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.domain.service.ProductService;

import java.math.BigDecimal;

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

    @Test
    void updateRating() {
        ProductModel testProduct = productService.createRandom("Test rating product", 1L);

        assertNotNull(testProduct);
        assertNotNull(testProduct.id());
        log.info("Created product: " + testProduct);


        // update 1
        productService.updateRating(testProduct.id(), BigDecimal.ONE);

        ProductModel product1 = productService.findById(testProduct.id());

        assertEquals("1.00", product1.rating().toPlainString());

        // update 2
        productService.updateRating(testProduct.id(), BigDecimal.TWO);
        ProductModel product2 = productService.findById(testProduct.id());

        assertEquals("2.00", product2.rating().toPlainString());
    }
}