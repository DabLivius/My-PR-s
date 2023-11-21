package com.myprs.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.myprs.servicio.UsuarioServicio;

/**
 * Configuración de seguridad para la aplicación.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServicio usuarioServicio;

    /**
     * Configura el codificador de contraseñas.
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configura el proveedor de autenticación personalizado.
     *
     * @return DaoAuthenticationProvider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioServicio);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    /**
     * Configura la autenticación para la aplicación.
     *
     * @param auth AuthenticationManagerBuilder
     * @throws Exception Si hay un error durante la configuración de la autenticación.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Configura la autorización y el manejo de formularios de inicio de sesión y cierre de sesión.
     *
     * @param http HttpSecurity
     * @throws Exception Si hay un error durante la configuración de la seguridad HTTP.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                .antMatchers(
                        "/registro**",
                        "/js/**",
                        "/css/**",
                        "/img/**").permitAll()
                .antMatchers("/historial/**").authenticated() // Solo usuarios autenticados pueden acceder a rutas que comienzan con /historial
                .anyRequest().permitAll())
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll())
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/")
                        .permitAll());
    }
}
