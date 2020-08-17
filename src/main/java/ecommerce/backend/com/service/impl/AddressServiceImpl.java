package ecommerce.backend.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.backend.com.model.Address;
import ecommerce.backend.com.payload.response.AddressResponse;
import ecommerce.backend.com.repository.AddressRepository;
import ecommerce.backend.com.service.AddressService;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressResponse> getAllAddressByUser(final Long userId) {
        return this.addressRepository.findByUser_idOrderByLogisticsStatusDescNameAsc(userId);
    }

    @Override
    public boolean deleteAddressById(Long id) {
        try {
            addressRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

}