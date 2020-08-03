package ecommerce.backend.com.controller;

import ecommerce.backend.com.model.CustomUserDetails;
import ecommerce.backend.com.model.User;
import ecommerce.backend.com.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Page<User>> getAllUser(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "1") Integer page) {
        if (search == null || search.isEmpty()) {
            return new ResponseEntity<>(userService.findAllUser(page, size), HttpStatus.OK);
        } else
            return new ResponseEntity<>(userService.findAllUserByEmail(search, page, size), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        Optional<User> userOptional = userService.findById(id);
        return userOptional
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/user/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> updateUserByUser(@PathVariable("id") Long id, @Valid @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            if (!id.equals(user.getId()))
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/admin/user/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @Valid @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id) {
        if (userService.deleteUserById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

}
