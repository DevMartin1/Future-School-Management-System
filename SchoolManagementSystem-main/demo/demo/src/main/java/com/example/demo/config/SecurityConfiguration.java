package com.example.demo.config;

import com.example.demo.service.CustomUserDetails;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.awt.font.FontRenderContext;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {


    @Autowired
    UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/register").permitAll()
                                .requestMatchers("/assets/**").permitAll()
                                .requestMatchers("/uploads/**").permitAll()
                                .requestMatchers("/uploads/staff/**").permitAll()
                                .requestMatchers("/admin_dashboard").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                ).formLogin(form -> form
                        .loginPage("/login")
                        .failureUrl("/login?error")
                        .successHandler(new CustomAuthenticationSuccessHandler())
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout").permitAll()
                        )
                        .httpBasic(Customizer.withDefaults()).build();

    }
    @Bean
    public AuthenticationManager authManager() {

        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authProvider);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
