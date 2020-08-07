package ecommerce.backend.com.service;

import java.util.List;

import ecommerce.backend.com.payload.request.CityRequest;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface CityService {
    
    /**
     * Tìm danh sách toàn bộ City
     * @return List<CityRequest> - Danh sách City 
     */
    List<CityRequest> findAllCity();
}