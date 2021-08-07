package com.pets.fibicado.petadoption.authentication;

import org.springframework.stereotype.Component;
import org.springframework.web.cors.*;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomCORSFilter extends OncePerRequestFilter {

    private final CorsProcessor processor  = new DefaultCorsProcessor();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);


        config.setAllowedOrigins(Arrays.asList("http://fibicado.com","http://localhost:8080"));

        config.setAllowedMethods(List.of("OPTIONS", "HEAD", "GET", "POST"));

        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);

        CorsConfiguration corsConfiguration = source.getCorsConfiguration(httpServletRequest);

        boolean isValid = this.processor.processRequest(corsConfiguration, httpServletRequest, httpServletResponse);

        if (!isValid || CorsUtils.isPreFlightRequest(httpServletRequest)) {

            return;

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
