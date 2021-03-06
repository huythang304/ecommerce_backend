package ecommerce.backend.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.backend.com.model.District;
import ecommerce.backend.com.payload.response.DistrictResponse;

import org.springframework.stereotype.Repository;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

    List<DistrictResponse> findAllByCity_IdOrderByNameAsc(Integer cityId);
    
}