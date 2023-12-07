package pl.jbazil.javabase.classis.orm.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.jbazil.javabase.classis.orm.domain.model.ProductModel;
import pl.jbazil.javabase.classis.orm.domain.service.ProductService;
import pl.jbazil.javabase.classis.orm.external.ThirdPartyService;

import java.util.List;

@Log
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ThirdPartyService thirdPartyService;

    public static volatile List<ProductModel> cache = List.of();


    @GetMapping("/")
    public List<ProductModel> getAll(
            @RequestParam(name = "page_num", defaultValue = "0") int pageNum,
            @RequestParam(name = "page_size", defaultValue = "100") int pageSize
    ) {
        log.info("Retrieving data from db");
        return productService.findAll(pageNum, pageSize);
    }

    @GetMapping("/cache")
    public List<ProductModel> getCache() {
        if (cache.isEmpty()) { //dummy cache
            cache = productService.findAll(0, 100);
            log.config("Updating cache");
        }
        log.info("Retrieving data from cache");
        return cache;
    }

    @GetMapping("/external_cache")
    public List<ProductModel> getExternalCache() {
        long measure = thirdPartyService.execAndMeasure();
        if (cache.isEmpty()) { //dummy cache
            cache = productService.findAll(0, 100);
            log.config("Updating cache");
        }
        log.info("Retrieving data from external cache (" + measure + " delay)");
        return cache;
    }

    @GetMapping("/external_db")
    public List<ProductModel> getExternalDb() {
        long measure = thirdPartyService.execAndMeasure();
        var result = productService.findAll(0, 100);
        log.info("Retrieving data from external db (" + measure + " delay)");
        return result;
    }
}
