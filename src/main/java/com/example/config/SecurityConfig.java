package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.repository.PlayerRepository;
import com.example.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(new UserDetailsServiceImpl(playerRepository))
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
    				.antMatchers("/js/**", "/bower_components/**", "/images/**", "/css/**", "/templates/**","/homepage.html","/","/player/create","/login.html").permitAll()
                    .anyRequest().authenticated()
                .and()
                     .formLogin()
                     .loginPage("/login.html")
                     .permitAll()
                     .defaultSuccessUrl("/index.html")
                .and()		
                	.logout()
					.logoutSuccessUrl("/homepage.html")
					.permitAll()
                .and()
                    .httpBasic()
                .and()
                    .csrf().disable();
    }
}
