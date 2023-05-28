package backend.app.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz
                // COMMON - GET
                .requestMatchers(HttpMethod.OPTIONS, "/sign").hasAnyRole(null, "USER", "ADMIN")
                // USER - GET
                .requestMatchers(HttpMethod.GET, "/contributions/{username}").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/contributions/{username}/{id}").hasRole("USER")
                // USER - POST
                .requestMatchers(HttpMethod.POST, "/contributions").hasRole("USER")
                // ADMIN - GET
                .requestMatchers(HttpMethod.GET, "/contributions").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/contributions/{username}/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                // ADMIN - POST
                .requestMatchers(HttpMethod.POST, "/contacts").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/infos").hasRole("ADMIN")
                // ADMIN - DELETE
                .requestMatchers(HttpMethod.DELETE, "/contacts/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/infos/{id}").hasRole("ADMIN")
                // ALL - GET
                .requestMatchers(HttpMethod.GET, "/contacts").permitAll()
                .requestMatchers(HttpMethod.GET, "/infos").permitAll()
                .requestMatchers(HttpMethod.GET, "/infos/{id}").permitAll()
                // ALL - POST
                .requestMatchers(HttpMethod.POST, "/users").permitAll());

        http.csrf(csrf -> csrf.disable());
        http.cors(cors -> cors.disable());
        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
