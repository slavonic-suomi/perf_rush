package pl.jbazil.javabase.classis.orm.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.jbazil.javabase.classis.orm.domain.model.CategoryModel;
import pl.jbazil.javabase.classis.orm.domain.service.CategoryService;
import pl.jbazil.javabase.classis.orm.web.model.category.CreateCategoryRequest;

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

    @PostMapping("/")
    public CategoryModel create(@RequestBody CreateCategoryRequest createRequest) {
        return categoryService.create(createRequest.getName());
    }
}
