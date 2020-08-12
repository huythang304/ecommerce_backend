package ecommerce.backend.com.service;

import java.util.List;

import ecommerce.backend.com.payload.response.WardResponse;

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
    List<WardResponse> findAllByDistrictId(Integer districtId);
}
