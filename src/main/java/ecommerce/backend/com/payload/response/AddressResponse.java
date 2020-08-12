package ecommerce.backend.com.payload.response;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface AddressResponse {
    
    Long getId();

    String getName();

    String getPhone();

    String getAddress();

    boolean getLogisticsStatus();

    @Value("#{target.ward}")
    WardResponse getWard();

    @Value("#{target.ward.district}")
    DistrictResponse getDistrict();

    @Value("#{target.ward.district.city}")
    CityResponse getCity();
}