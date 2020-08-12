package ecommerce.backend.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.backend.com.model.City;
import ecommerce.backend.com.payload.response.CityResponse;

import org.springframework.stereotype.Repository;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<CityResponse> findByOrderByNameAsc();

}