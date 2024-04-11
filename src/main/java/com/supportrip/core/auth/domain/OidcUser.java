package com.supportrip.core.auth.domain;

import com.supportrip.core.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class OidcUser implements UserDetails {
    private final Long userId;
    private final Set<GrantedAuthority> authorities;
    private final boolean accountNonLocked;
    private final boolean enabled;

    @Builder(access = AccessLevel.PRIVATE)
    private OidcUser(Long userId, Set<GrantedAuthority> authorities, boolean accountNonLocked, boolean enabled) {
        this.userId = userId;
        this.authorities = authorities;
        this.accountNonLocked = accountNonLocked;
        this.enabled = enabled;
    }

    public static OidcUser from(User user) {
        return OidcUser.builder()
                .userId(user.getId())
                .authorities(user.getAuthorities())
                .accountNonLocked(user.isLocked())
                .enabled(user.isEnabled())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return userId.toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getUserId() {
        return userId;
    }
}
