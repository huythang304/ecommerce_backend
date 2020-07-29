package ecommerce.backend.com.repository;

import ecommerce.backend.com.model.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	List<Category> findByStatusOrderByIdAsc(Integer status);

	Page<Category> findByOrderByIdAsc(Pageable pageable);

	Page<Category> findByNameContainingOrderByIdAsc(String search, Pageable pageable);

	@Query(nativeQuery = true,
	value = "SET @pv = :cid;SELECT c.id FROM Category c WHERE (FIND_IN_SET(c.parent_id, @id) AND @id\\:= CONCAT(@id, ',' , c.id)) OR c.id=@id")
	List<Integer> findAllCategoryIdChild(@Param("cid")Integer id);
}
