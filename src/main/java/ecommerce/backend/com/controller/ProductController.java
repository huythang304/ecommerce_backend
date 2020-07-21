package ecommerce.backend.com.controller;

import ecommerce.backend.com.model.Product;
import ecommerce.backend.com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Page<Product>> getCategoryById(
            @PathVariable(name = "categoryId", required = true) Integer id,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "1") Integer page) {
        return new ResponseEntity<>(productService.findAllByCategoryIdAndStatus(id, page, size, 1), HttpStatus.OK);
    }

}
