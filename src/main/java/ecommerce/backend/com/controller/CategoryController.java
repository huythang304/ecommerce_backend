package ecommerce.backend.com.controller;

import ecommerce.backend.com.model.Category;
import ecommerce.backend.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/categories")
    public ResponseEntity<Page<Category>> getAllCategory(
            @RequestParam(required = false) String search,            
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "1") Integer page) {
                if(search == null || search.isEmpty() ){
                    return new ResponseEntity<>(categoryService.findAllByPage(page, size),HttpStatus.OK);
                }else
                    return new ResponseEntity<>(categoryService.findAllByNameAndPage(search, page, size), HttpStatus.OK);
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
        Optional<Category> categoryOptional = categoryService.findCategoryById(id);
        return categoryOptional
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/category/{id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable("id") Integer id, @Valid @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.findCategoryById(id);
        if (categoryOptional.isPresent()) {
            return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/category")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") Integer id) {
        if (categoryService.deleteCategoryById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
