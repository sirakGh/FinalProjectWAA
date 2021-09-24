package edu.miu.ecommerce.configuration.security;

import edu.miu.ecommerce.domain.User;
import edu.miu.ecommerce.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDAO.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("NOT FOUND"));
        return new CustomUserDetails(user.get());
    }
}
