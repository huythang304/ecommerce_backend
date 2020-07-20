package ecommerce.backend.com.service.impl;

import ecommerce.backend.com.model.CustomUserDetails;
import ecommerce.backend.com.model.User;
import ecommerce.backend.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userService.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Email " + email + " was not found in the database");
        }

        return new CustomUserDetails(user, getRoleFromUser(user));
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = this.userService.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        return new CustomUserDetails(user, getRoleFromUser(user));
    }

    public List<GrantedAuthority> getRoleFromUser(User user) {
        List<GrantedAuthority> grantList = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
        grantList.add(authority);
        return grantList;
    }
}
