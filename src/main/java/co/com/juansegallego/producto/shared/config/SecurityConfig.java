package co.com.juansegallego.producto.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

        http
                //Configurar autorización de peticiones
                .authorizeHttpRequests( auth -> auth
                        //Permitir todas las peticiones OPTIONS (preflight CORS)
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                        //Permitir acceso publico a Swagger y OpenAPI
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**")
                        .permitAll()

                        //Permitir acceso publico a actuator (Opcional)
                        .requestMatchers("/actuator/**").permitAll()

                        //Todas las demas rutas requieren autenticación
                        .anyRequest().authenticated())

                //Configurar OAuth2 Resource Servere con JWT
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> {
                        }))

                //Sin estado (stateless) para APIs REST
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
