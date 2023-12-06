package pl.jbazil.javabase.classis.orm.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jbazil.javabase.classis.orm.domain.model.CategoryModel;
import pl.jbazil.javabase.classis.orm.domain.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryModel> findAllNames() {
        return categoryService.findAllWithTopProducts(0, 10, 10);

    }
}
