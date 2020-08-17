package ecommerce.backend.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import ecommerce.backend.com.model.Address;
import ecommerce.backend.com.payload.response.AddressResponse;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface AddressRepository extends JpaRepository<Address, Long>{
    
    List<AddressResponse> findByUser_idOrderByLogisticsStatusDescNameAsc(Long userId);

    /**
     * Thực Hiện Cập nhật địa chỉ mặc định
     *
     * @param userId Long
     * @param addressId Long
     * @return true - nếu cập nhật thành công / false - nếu cập nhật thất bại và roll back dữ liệu
     */
    @Procedure("updateDefaultAddress")
    boolean updateDefaultAddress(@Param("userId") Long userId, @Param("addressId") Long addressId);
}