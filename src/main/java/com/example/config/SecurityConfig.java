package com.example.config;

import com.example.SimpleSocialUsersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.antMatcher("/**")
                .authorizeRequests().antMatchers("/lol.html").authenticated()
                .antMatchers("/", "/auth/**", "/webjars/**", "/js/**", "/signup**").permitAll()
                .anyRequest().authenticated()
                .and().apply(new SpringSocialConfigurer());
        // @formatter:on
    }

    @Bean
    public SocialUserDetailsService socialUsersDetailService() {
        return new SimpleSocialUsersDetailService(userDetailsService());
    }
}
