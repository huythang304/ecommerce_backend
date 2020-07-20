package ecommerce.backend.com.service.impl;

import ecommerce.backend.com.model.Category;
import ecommerce.backend.com.repository.CategoryRepository;
import ecommerce.backend.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllByStatus(Integer status) {
        return categoryRepository.findByStatusOrderByIdAsc(status);
    }

    @Override
    public Optional<Category> findCategoryById(Integer id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

}
