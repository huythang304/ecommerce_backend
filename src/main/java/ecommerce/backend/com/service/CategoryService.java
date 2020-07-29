package ecommerce.backend.com.service;

import ecommerce.backend.com.model.Category;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

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

	/**
	 * Xóa thể loại theo Id
	 * @param id Integer - Id của thể loại cần xóa
	 * @return true - nếu xóa thành công / false - nếu không xóa thành công
	 */
	boolean deleteCategoryById(Integer id);

	/**
	 * Tìm danh sách thể loại theo phân trang
	 * @param page Integer Số trang
	 * @param size Integer Số lượng thể loại trong một trang
	 * @return Page<Category> 
	 */
	Page<Category> findAllByPage(Integer page, Integer size);

	/**
	 * Tìm danh sách thể loại theo từ khóa tìm kiếm và phân trang
	 * @param search String từ khóa tìm kiếm
	 * @param page Integer Số trang
	 * @param size Integer Số lượng thể loại trong một trang
	 * @return Page<Category>1
	 */
	Page<Category> findAllByNameAndPage(String search, Integer page, Integer size);

	List<Integer> findAllChildId(Integer id);
}
