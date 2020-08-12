package ecommerce.backend.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.backend.com.payload.response.CityResponse;
import ecommerce.backend.com.repository.CityRepository;
import ecommerce.backend.com.service.CityService;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityResponse> findAllCity() {
        return cityRepository.findByOrderByNameAsc();
    }
    
}