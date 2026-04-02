package se.iths.paveena.demospringsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authorization.EnableMultiFactorAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.FactorGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;
import se.iths.paveena.springmessenger.service.MessageService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
//@EnableMultiFactorAuthentication(
//        authorities = {
//                FactorGrantedAuthority.PASSWORD_AUTHORITY,
//                FactorGrantedAuthority.OTT_AUTHORITY
//
//        }
//)
public class SecurityConfig {

    //private MessageService messageService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new  BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, OttSuccessHandler ottSuccessHandler) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/public/**", "/ott/sent", "/actuator/**").permitAll()
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
                .anyRequest().authenticated()

        )
//         .oneTimeTokenLogin(
//                ott -> ott.tokenGenerationSuccessHandler(
//
//                ottSuccessHandler
//        ))
        .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public RedirectOneTimeTokenGenerationSuccessHandler redirectOneTimeTokenGenerationSuccessHandler() {
        return new RedirectOneTimeTokenGenerationSuccessHandler("/ott/sent");
    }
}
