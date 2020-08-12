package ecommerce.backend.com.payload.response;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

public interface WardResponse {

    Integer getId();

    @Value("#{target.prefix + ' ' + target.name}")
    String getFullName();
}
