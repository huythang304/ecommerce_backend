package ecommerce.backend.com.controller;

import ecommerce.backend.com.payload.request.CityRequest;
import ecommerce.backend.com.payload.request.DistrictRequest;
import ecommerce.backend.com.payload.request.WardRequest;
import ecommerce.backend.com.service.CityService;
import ecommerce.backend.com.service.DistrictService;
import ecommerce.backend.com.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1")
public class AddressController {

    private final CityService cityService;

    private final DistrictService districtService;

    private final WardService wardService;

    @Autowired
    public AddressController(CityService cityService, DistrictService districtService, WardService wardService) {
        this.cityService = cityService;
        this.districtService = districtService;
        this.wardService = wardService;
    }

    @GetMapping(value = "/address/city")
    public ResponseEntity<List<CityRequest>> getListCity() {
        return new ResponseEntity<>(cityService.findAllCity(), HttpStatus.OK);
    }

    @GetMapping(value = "/address/district/{id}")
    public ResponseEntity<List<DistrictRequest>> getListDistrictByCityId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(districtService.findAllDistrictByCity(id), HttpStatus.OK);
    }

    @GetMapping(value = "/address/ward/{id}")
    public ResponseEntity<List<WardRequest>> getListWardByDistrictId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(wardService.findAllByDistrictId(id), HttpStatus.OK);
    }

    
}