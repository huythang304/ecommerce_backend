package ecommerce.backend.com.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Data
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Email đăng nhập không được để trống")
    @Email(message = "Email đăng nhập không đúng định dạng")
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;

}
