package ecommerce.backend.com.service;

import ecommerce.backend.com.model.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface CategoryService {

	/**
     * Lấy danh sách tất cả Thể loại
     *
     * @return List<Category> - danh sách thể loại
     */
	List<Category> findAll();

	/**
     * Lấy danh sách tất cả Thể loại theo
     *
     * @param status Integer
     * @return List<Category> - danh sách thể loại
     */
	List<Category> findAllByStatus(Integer status);

	/**
	 * Tìm thể loại theo
	 * @param id Id của thể loại cần tìm
	 * @return Optional<Category>
	 */
	Optional<Category> findCategoryById(Integer id);

	/**
	 * Thêm mới/Cập nhật thể loại
	 * @param category Category
	 * @return category - nếu cập nhật thành công, null - nếu cập nhật không thành công
	 */
	Category save(Category category);
}
