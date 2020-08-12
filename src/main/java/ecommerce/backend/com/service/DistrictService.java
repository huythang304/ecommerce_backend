package ecommerce.backend.com.service;

import java.util.List;

import ecommerce.backend.com.payload.response.DistrictResponse;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface DistrictService {
    
    /**
     * Tìm danh sách District theo Id City
     * @param cityId Integer
     * @return List<DistrictRequest> - Danh sách District
     */
    List<DistrictResponse> findAllDistrictByCity(Integer cityId);
}