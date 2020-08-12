package ecommerce.backend.com.controller;

import ecommerce.backend.com.model.Address;
import ecommerce.backend.com.payload.request.AddressRequest;
import ecommerce.backend.com.payload.response.AddressResponse;
import ecommerce.backend.com.payload.response.CityResponse;
import ecommerce.backend.com.payload.response.DistrictResponse;
import ecommerce.backend.com.payload.response.WardResponse;
import ecommerce.backend.com.service.AddressService;
import ecommerce.backend.com.service.CityService;
import ecommerce.backend.com.service.DistrictService;
import ecommerce.backend.com.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1")
public class AddressController {

    private final AddressService addressService;

    private final CityService cityService;

    private final DistrictService districtService;

    private final WardService wardService;

    @Autowired
    public AddressController(AddressService addressService, CityService cityService, DistrictService districtService, WardService wardService) {
        this.addressService = addressService;
        this.cityService = cityService;
        this.districtService = districtService;
        this.wardService = wardService;
    }

    @GetMapping(value = "/address/city")
    public ResponseEntity<List<CityResponse>> getListCity() {
        return new ResponseEntity<>(cityService.findAllCity(), HttpStatus.OK);
    }

    @GetMapping(value = "/address/district/{cityId}")
    public ResponseEntity<List<DistrictResponse>> getListDistrictByCityId(@PathVariable("cityId") Integer cityId) {
        return new ResponseEntity<>(districtService.findAllDistrictByCity(cityId), HttpStatus.OK);
    }

    @GetMapping(value = "/address/ward/{districtId}")
    public ResponseEntity<List<WardResponse>> getListWardByDistrictId(@PathVariable("districtId") Integer districtId) {
        return new ResponseEntity<>(wardService.findAllByDistrictId(districtId), HttpStatus.OK);
    }

    @GetMapping(value = "/address/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AddressResponse>> getListAddressByUser(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(addressService.getAllAddressByUser(userId), HttpStatus.OK);
    }

    @PostMapping(value = "/address")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Address> createAddress(@Valid @RequestBody AddressRequest address) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/address/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> deleteAddress(@PathVariable("id") Long id) {
        Optional<Address> addressOptional = addressService.findAddressById(id);
        if(addressOptional.isPresent()){
            if(addressOptional.get().isLogisticsStatus())
                return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
            else{
                if (addressService.deleteAddressById(id))
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                else
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }     
    }

    @PutMapping(value = "/address/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<AddressRequest> updateAddress(@PathVariable("id") Long id,
                                                        @Valid @RequestBody AddressRequest address){
        Optional<Address> addressOptional = addressService.findAddressById(id);
        if(addressOptional.isPresent())
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}