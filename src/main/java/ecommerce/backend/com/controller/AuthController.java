package ecommerce.backend.com.controller;

import ecommerce.backend.com.model.Role;
import ecommerce.backend.com.model.User;
import ecommerce.backend.com.payload.request.LoginRequest;
import ecommerce.backend.com.payload.request.SignupRequest;
import ecommerce.backend.com.payload.response.LoginResponse;
import ecommerce.backend.com.security.jwt.JwtUtils;
import ecommerce.backend.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = jwtUtils.generateToken(authentication);

        return new ResponseEntity<>(new LoginResponse(jwt), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8);
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setPhone(signupRequest.getPhone());
        Role role = new Role();
        role.setId(1);
        user.setRole(role);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
