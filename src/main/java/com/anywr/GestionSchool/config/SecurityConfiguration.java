package com.anywr.GestionSchool.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.anywr.GestionSchool.filter.AuthTokenFilter;
import com.anywr.GestionSchool.services.AuthEntryPointJwt;
import com.anywr.GestionSchool.services.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

	private UserDetailsServiceImpl userDetailsService;
	private AuthEntryPointJwt authEntryPointJwt;
	private AuthTokenFilter authTokenFilter;

	public SecurityConfiguration(UserDetailsServiceImpl userDetailsService, AuthEntryPointJwt authEntryPointJwt, AuthTokenFilter authTokenFilter) {
	        
        this.userDetailsService = userDetailsService;
	    this.authEntryPointJwt = authEntryPointJwt;
	    this.authTokenFilter = authTokenFilter;
	    
    }

	@Bean   
    PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();   
    }

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	@Primary
	AuthenticationManagerBuilder configureAuthenticationManagerBuilder(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    return authenticationManagerBuilder;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.cors().and().csrf().disable()
	                .exceptionHandling().authenticationEntryPoint(authEntryPointJwt).and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
	                .antMatchers("/api/test/**").authenticated()
	                .antMatchers("/api/etudiants/**").authenticated()
	              
	                .anyRequest().authenticated();
	        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	}
	    
	    
}
