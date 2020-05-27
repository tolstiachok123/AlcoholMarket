package com.am.security.provider;

import com.am.dao.RoleDao;
import com.am.dao.UserDao;
import com.am.model.Role;
import com.am.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppSecurityProvider implements AuthenticationProvider {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userDao.findByUsername(authentication.getName());
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not found: %s", authentication.getName()));
        }
        String password = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Incorrect username or password");
        }
        List<Role> roles = roleDao.findAllRoles(user.getId());
        List<SimpleGrantedAuthority> authorities = roles.stream().map(it -> new SimpleGrantedAuthority("ROLE_" + it.getRole())).collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
