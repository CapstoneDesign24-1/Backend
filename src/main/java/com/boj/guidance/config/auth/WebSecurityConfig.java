//package com.boj.guidance.config.auth;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//
//                .authorizeHttpRequests((authorizeRequests) -> {
////                    authorizeRequests.requestMatchers("home", "/", "/login", "/join", "/member/**").permitAll();
////                    authorizeRequests.requestMatchers("/api/v1/**").authenticated();
//                    authorizeRequests.anyRequest().permitAll();
//                })
//
////                .formLogin((formLogin) -> {
////                    formLogin
////                            .loginPage("/login")
////                            .defaultSuccessUrl("/home");
////                })
//                .build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
