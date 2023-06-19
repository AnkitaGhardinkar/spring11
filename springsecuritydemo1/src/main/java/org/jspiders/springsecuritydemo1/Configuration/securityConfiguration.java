package org.jspiders.springsecuritydemo1.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails ankita= User.builder()
                .username("ankita")
                .password("{noop}123")
                .roles("TRACKER")
                .build();

        UserDetails gayatri= User.builder()
                .username("gayatri")
                .password("{noop}456")
                .roles("TRACKER","HR")
                .build();


        UserDetails shivani= User.builder()
                .username("shivani")
                .password("{noop}789")
                .roles("TRACKER","HR","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(ankita,gayatri,shivani);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.authorizeHttpRequests(config->
                config
                        .requestMatchers("/").hasRole("TRACKER")
                        .requestMatchers("/requirements").hasAnyRole("HR","ADMIN")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();

    }
}
