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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppSecurityProvider implements AuthenticationProvider {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userDao.findByUsername(authentication.getName());
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not found: %s", authentication.getName()));
        }
        String password = authentication.getCredentials().toString();
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Incorrect username or password");
        }
        ArrayList<Role> roles = roleDao.findAllRoles();
        List<SimpleGrantedAuthority> authorities = roles.stream().map(it -> new SimpleGrantedAuthority("ROLE_" + it.getRole())).collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
