package com.krishantha.rentcloud.authorizationserver.model;

import com.krishantha.rentcloud.authorizationserver.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthUser implements UserDetails {

    private boolean enabled;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private String password;
    private String userName;

    public AuthUser(final User user) {
        enabled = user.getEnabled() == 1;
        credentialsNonExpired = user.getCredentialsNonExpired() == 1;
        accountNonLocked = user.getAccountNonLocked() == 1;
        accountNonExpired = user.getAccountNonExpired() == 1;
        password = user.getPassword();
        userName = user.getUsername();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO finish this
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
