package ecommerce.backend.com.repository;

import ecommerce.backend.com.model.Ward;
import ecommerce.backend.com.payload.response.WardResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Repository
public interface WardRepository extends JpaRepository<Ward, Integer> {

    List<WardResponse> findByDistrict_IdOrderByNameAsc(Integer districtId);
}
