package ecommerce.backend.com.service;

import java.util.List;
import java.util.Optional;

import ecommerce.backend.com.model.Address;
import ecommerce.backend.com.payload.response.AddressResponse;


/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface AddressService {

    /**
     * Lấy danh sách Địa chỉ của người dùng
     * @param userId
     * @return
     */
    List<AddressResponse> getAllAddressByUser(Long userId);

    
	/**
	 * Xóa địa chỉ theo Id
	 * @param id Long - Id của địa chỉ cần xóa
	 * @return true - nếu xóa thành công / false - nếu không xóa thành công
	 */
	boolean deleteAddressById(Long id);

    /**
	 * Tìm địa chỉ theo Id
	 * @param id Long - Id của địa chỉ cần xóa
	 * @return Optional<Address>
	 */
	Optional<Address> findAddressById(Long id);

}