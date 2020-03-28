package com.krishantha.rentcloud.authorizationserver.service;

import com.krishantha.rentcloud.authorizationserver.entity.User;
import com.krishantha.rentcloud.authorizationserver.model.AuthUser;
import com.krishantha.rentcloud.authorizationserver.repository.UserRepository;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("Couldn't find user with name " + name));
        final var authUser = new AuthUser(user);
        new AccountStatusUserDetailsChecker().check(authUser);
        return authUser;
    }

}
