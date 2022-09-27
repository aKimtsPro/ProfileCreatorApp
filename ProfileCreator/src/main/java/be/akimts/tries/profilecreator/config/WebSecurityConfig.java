package be.akimts.tries.profilecreator.config;

import be.akimts.lib.jwt.filter.JwtAuthFilter;
import be.akimts.tries.profilecreator.listeners.PasswordEncoderListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@ComponentScan("be.akimts.lib.jwt")
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter filter) throws Exception {

        http.csrf().disable();

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        http.authorizeHttpRequests()
                .anyRequest().permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        // TODO feels dirty
        PasswordEncoderListener.setPasswordEncoder( encoder );
        return encoder;
    }

}
