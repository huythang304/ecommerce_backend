package ecommerce.backend.com.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Data
@NoArgsConstructor
public class SignupRequest {

    @NotBlank(message = "Email đăng nhập không được để trống")
    @Email(message = "Email đăng nhập không đúng định dạng")
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 8, max = 13, message = "Mật khẩu dài từ 8 - 13 ký tự")
    private String password;

    @NotBlank(message = "Số điện thoại không được để trống")
    private String phone;
}
