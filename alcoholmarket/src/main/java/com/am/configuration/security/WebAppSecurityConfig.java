package com.am.configuration.security;

import com.am.security.handler.AppSecurityHandler;
import com.am.security.provider.AppSecurityProvider;
import com.am.security.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailsService detailsService;

    @Autowired
    private AppSecurityProvider securityProvider;

    @Autowired
    private AppSecurityHandler securityHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.authenticationProvider(securityProvider);
    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/mainPage").permitAll()
                .antMatchers("/second").authenticated()
                .antMatchers("/third").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedHandler(securityHandler);
    }
}
