package ecommerce.backend.com.service.impl;

import ecommerce.backend.com.payload.response.DistrictResponse;
import ecommerce.backend.com.repository.DistrictRepository;
import ecommerce.backend.com.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Service
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public List<DistrictResponse> findAllDistrictByCity(Integer cityId) {
        return districtRepository.findAllByCity_IdOrderByNameAsc(cityId);
    }
}
