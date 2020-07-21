package ecommerce.backend.com.service.impl;

import ecommerce.backend.com.repository.ProductRepository;
import ecommerce.backend.com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Category> findAllByCategoryIdAndStatus(Integer categoryId,Integer page, Integer size, Integer status){

    }
}
