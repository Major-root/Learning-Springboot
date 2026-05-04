package com.stanley.learningspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(csrf -> csrf.disable()).
                authorizeHttpRequests(auth->
                auth.requestMatchers("/user/register").permitAll().
                        anyRequest().authenticated())
                .formLogin(form-> form.disable() )
                .httpBasic(httpBasic ->httpBasic.disable() );

                return httpSecurity.build();
    }
}
