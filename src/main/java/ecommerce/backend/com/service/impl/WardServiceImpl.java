package ecommerce.backend.com.service.impl;

import ecommerce.backend.com.payload.request.WardRequest;
import ecommerce.backend.com.repository.WardRepository;
import ecommerce.backend.com.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService {

    private final WardRepository wardRepository;

    @Autowired
    public WardServiceImpl(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    @Override
    public List<WardRequest> findAllByDistrictId(Integer districtId) {
        return wardRepository.findByDistrict_IdOrderByNameAsc(districtId);
    }
}
