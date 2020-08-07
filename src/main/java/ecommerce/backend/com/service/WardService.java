package ecommerce.backend.com.service;

import ecommerce.backend.com.payload.request.WardRequest;

import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface WardService {

    /**
     * Tìm danh sách Ward theo district ID
     * @param districtId Integer
     * @return List<WardRequest> - danh sách ward theo district ID;
     */
    List<WardRequest> findAllByDistrictId(Integer districtId);
}
