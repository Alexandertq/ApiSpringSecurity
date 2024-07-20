package com.alex.security;

import com.alex.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()

                .antMatchers("/libro/listar", "/libro/buscar/*",
                                        "/detalle/listar", "/detalle/buscar/*",
                                        "/editorial/listar", "/editorial/buscar/*",
                                        "/genero/listar", "/genero/buscar/*")
                .access("hasRole('USER') or hasRole('ADMIN') or (hasRole('ADMIN') and hasRole('DBA'))")

                .antMatchers("/libro/registrar", "/libro/editar/*",
                                        "/detalle/registrar", "/detalle/editar/*",
                                        "/editorial/registrar", "/editorial/editar/*",
                                        "/genero/registrar", "/genero/editar/*")
                .access("hasRole('ADMIN') or (hasRole('ADMIN') and hasRole('DBA'))")

                .antMatchers("/editorial/borrar/*", "/detalle/borrar/*", "/genero/borrar/*", "/libro/borrar/*",
                                        "/usuario/listar", "/usuario/buscar/*",
                                        "/usuario/registrar", "/usuario/editar/*",
                                        "/usuario/borrar/*")
                .access("hasRole('ADMIN') and hasRole('DBA')")

                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpServletResponse.getWriter().write("Acceso denegado");
        };
    }
}
