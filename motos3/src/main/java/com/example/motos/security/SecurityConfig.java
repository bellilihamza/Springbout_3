package com.example.motos.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	 @Bean
	 SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {      
		 	 http.authorizeHttpRequests((requests)->requests
	                		.requestMatchers("/showCreate","/saveProduit").hasAnyAuthority("ADMIN","AGENT")
	                		.requestMatchers("/ListeProduits").hasAnyAuthority("ADMIN","AGENT","USER")
	                		.requestMatchers("/login","/webjars/**").permitAll()
	                		.anyRequest().authenticated())
                   	                
	                .formLogin((formLogin) ->   formLogin
	                		 		.loginPage("/login")
	                		 		.defaultSuccessUrl("/") )
	                
	                .httpBasic(Customizer.withDefaults())
	                .exceptionHandling((exception)-> exception.accessDeniedPage("/accessDenied"));
	        return http.build();
	    }
	
}