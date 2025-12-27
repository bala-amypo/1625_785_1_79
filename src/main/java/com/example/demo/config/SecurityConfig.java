package com.example.springboot.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.springboot.Security.JwtFilter;

@Configuration // to denote it as a config file
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
@Autowired
    private JwtFilter jwtFilter;
    @Bean // method to be considered as class
    public PasswordEncoder passwordEncoder() { // to store password
        return new BCryptPasswordEncoder(); // t allocate different memories for passwirds generated
    }
    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) // to enable requests , SecurityFilterChain class is used || requests are all comes to HttpSecurity
        throws Exception {

    http
        .csrf(csrf -> csrf.disable()) // csrf - Cross Site Request Forgery (disabled) - token format (low level)
        .authorizeHttpRequests(auth -> auth // to check end point (/auth)
            .requestMatchers("/auth/**").permitAll() // to permit /auth/register/saveextrastudent
            .requestMatchers(
                "/swagger-ui/**",
                "/v3/api-docs/**"
            ).permitAll()
            .anyRequest().
            authenticated()) // to check only the request given not other requests
.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);

    return http.build();
}

}