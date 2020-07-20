package ecommerce.backend.com.repository;

import ecommerce.backend.com.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findCategoryById(Integer id);

	List<Category> findAll();

	List<Category> findByStatusOrderByIdAsc(Integer status);

}
