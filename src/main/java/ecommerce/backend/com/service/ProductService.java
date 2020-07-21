package ecommerce.backend.com.service;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface ProductService {

	/**
	 * Tìm danh sách Sản Phẩm theo phân trang
	 * @param page Integer Số trang
	 * @param size Integer Số lượng thể loại trong một trang
	 * @return Page<Category> 
	 */
	Page<Category> findAllByCategoryIdAndStatus(Integer categoryId,Integer page, Integer size, Integer status);

}
