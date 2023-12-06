package pl.jbazil.javabase.classis.orm.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.domain.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    public static final List<ProductModel> cache = List.of(
            new ProductModel(1L, "phone 1", "code 1", new BigDecimal("1.72"), 1L),
            new ProductModel(2L, "phone 2", "code 2", new BigDecimal("2.12"), 1L),
            new ProductModel(3L, "phone 3", "code 3", new BigDecimal("3.12"), 1L),
            new ProductModel(4L, "phone 4", "code 4", new BigDecimal("4.12"), 1L),
            new ProductModel(5L, "phone 5", "code 5", new BigDecimal("4.22"), 1L)
    );

    @GetMapping("/cache")
    public List<ProductModel> getCache() {
        return cache;
    }

    @GetMapping("/")
    public List<ProductModel> getAll() {
        return productService.findAll(0, 100);
    }

}
