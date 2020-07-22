package ecommerce.backend.com.service.impl;

import ecommerce.backend.com.model.Category;
import ecommerce.backend.com.model.Product;
import ecommerce.backend.com.repository.ProductRepository;
import ecommerce.backend.com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> findAllByCategoryIdAndStatus(Integer categoryId, Integer page, Integer size, Integer status) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return productRepository.findAllByCategory_IdAndStatus(categoryId, status, pageable);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
