package pl.jbazil.javabase.classis.orm.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.domain.service.ProductService;
import pl.jbazil.javabase.classis.orm.domain.storage.ProductStorage;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {

    private final ProductStorage productStorage;

    private final Random random = new Random();
    private final BigDecimal ONE_HUNDRED = new BigDecimal(100);


    @Override
    public ProductModel createRandom(String name, Long categoryId) {
        ProductModel model = new ProductModel(
                null,
                name,
                UUID.randomUUID().toString(),
                new BigDecimal(random.nextInt(100, 500)).divide(ONE_HUNDRED, MathContext.DECIMAL32),
                categoryId
        );

        return productStorage.create(model);
    }

    @Override
    public List<ProductModel> findAll(int pageNum, int pageSize) {
        return productStorage.findAll(pageNum, pageSize);
    }

    @Override
    public ProductModel updateRating(Long id, BigDecimal rating) {
        return productStorage.updateRating(id, rating);
    }

    @Override
    public ProductModel findById(Long id) {
        return productStorage.findById(id);
    }
}
