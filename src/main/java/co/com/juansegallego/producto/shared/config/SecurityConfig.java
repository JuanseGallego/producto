package co.com.juansegallego.producto.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

        http
                // Deshabilitar CSRF para APIs REST stateless
                .csrf(AbstractHttpConfigurer::disable)

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
                        .anyRequest().permitAll())

                //Configurar OAuth2 Resource Servere con JWT
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtAuthenticationConverter())
                        ))

                //Sin estado (stateless) para APIs REST
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    /**
     * Configura el convertidor JWT para extraer los roles de realm_access.roles
     */
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new JwtAuthConverter());
        return jwtAuthenticationConverter;
    }
}
