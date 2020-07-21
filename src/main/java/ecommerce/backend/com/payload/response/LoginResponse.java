package ecommerce.backend.com.payload.response;

import lombok.Data;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Data
public class LoginResponse {

    private String accessToken;
    private String tokenType = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
