package io.github.tiagoboldori.eventhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/auth/login",
                                "/auth/register",
                                "/css/**",
                                "/js/**"
                        ).permitAll()

                        .anyRequest().authenticated()
                )

                .formLogin(login -> login

                        .loginPage("/auth/login")

                        .loginProcessingUrl("/auth/login")

                        .defaultSuccessUrl("/dashboard")

                        .failureUrl("/auth/login?error")

                        .permitAll()
                )

                .logout(logout -> logout

                        .logoutUrl("/auth/logout")

                        .logoutSuccessUrl("/auth/login")

                );


        return http.build();
    }
}