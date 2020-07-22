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
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Page<Product>> getProductsById(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "1") Integer page) {
        return new ResponseEntity<>(productService.findAllByCategoryIdAndStatus(id, page, size, 1), HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable Long id) {
        Optional<Product> productOptional = productService.findProductById(id);
        return productOptional
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/product/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Long id, @Valid @RequestBody Product product) {
        Optional<Product> productOptional = productService.findProductById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/product")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/product/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id) {
        if (productService.deleteProductById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
