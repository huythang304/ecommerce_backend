package ecommerce.backend.com.service;

import ecommerce.backend.com.model.User;

import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */
public interface UserService {

    User findUserByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    Optional<User> findById(Long id);
}
