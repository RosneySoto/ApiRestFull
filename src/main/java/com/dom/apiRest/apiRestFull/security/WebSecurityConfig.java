package com.dom.apiRest.apiRestFull.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtRequestFilter jwtRequest;
	
	@Autowired
	JwtAuthenticationEntrypoint jswtaAuthenticationEntrypoint;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()		//Permite llamar de cualquier metodo HTTP nuestra api
		.authorizeHttpRequests().anyRequest().permitAll()
		.and().exceptionHandling().authenticationEntryPoint(jswtaAuthenticationEntrypoint)
		.and().addFilterBefore(jwtRequest, UsernamePasswordAuthenticationFilter.class);
	}
	
}
