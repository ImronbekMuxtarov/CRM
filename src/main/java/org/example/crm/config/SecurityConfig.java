package org.example.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/api/accept-document/**").hasRole("acceptor")
                        .requestMatchers("/api/selling-document/**").hasRole("seller")
                        .anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User
                .builder()
                .username("user")
                .password(passwordEncoder.encode("1234"))
                .roles("user")
                .build();

        UserDetails user2 = User
                .builder()
                .username("admin")
                .password(passwordEncoder.encode("1234"))
                .roles("admin")
                .build();

        return new InMemoryUserDetailsManager(user1,
                user2);
    }
}