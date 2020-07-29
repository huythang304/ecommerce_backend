package ecommerce.backend.com.service.impl;

import ecommerce.backend.com.model.Category;
import ecommerce.backend.com.repository.CategoryRepository;
import ecommerce.backend.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

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

    @Override
    public boolean deleteCategoryById(Integer id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Page<Category> findAllByPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return categoryRepository.findByOrderByIdAsc(pageable);
    }

    @Override
    public Page<Category> findAllByNameAndPage(String search, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return categoryRepository.findByNameContainingOrderByIdAsc(search, pageable);
    }

    @Override
    public List<Integer> findAllChildId(Integer id) {
        return categoryRepository.findAllCategoryIdChild(id);
    }
}
