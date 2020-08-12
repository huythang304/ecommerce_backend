package ecommerce.backend.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.backend.com.model.Address;
import ecommerce.backend.com.payload.response.AddressResponse;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface AddressRepository extends JpaRepository<Address, Long>{
    
    List<AddressResponse> findByUser_idOrderByLogisticsStatusDescNameAsc(Long userId);

}