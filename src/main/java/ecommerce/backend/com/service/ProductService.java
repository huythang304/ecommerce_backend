package ecommerce.backend.com.service;

import ecommerce.backend.com.model.Category;
import ecommerce.backend.com.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface ProductService {

	/**
	 * Tìm danh sách Sản Phẩm theo phân trang
	 * @param page Integer Số trang
	 * @param size Integer Số lượng thể loại trong một trang
	 * @return Page<Product>
	 */
	Page<Product> findAllByCategoryIdAndStatus(Integer categoryId, Integer page, Integer size, Integer status);

	/**
	 * Tìm sản phẩm theo ID
	 * @param id Long Id sản phẩm
	 * @return Optional<Product>
	 */
	Optional<Product> findProductById(Long id);

	/**
	 * Thêm mới/Cập nhật sản phẩm
	 * @param product Product
	 * @return Product - nếu cập nhật thành công, null - nếu cập nhật không thành công
	 */
	Product save(Product product);

	/**
	 * Xóa thể loại theo Id
	 * @param id Integer - Id của thể loại cần xóa
	 * @return true - nếu xóa thành công / false - nếu không xóa thành công
	 */
	boolean deleteProductById(Long id);
}
