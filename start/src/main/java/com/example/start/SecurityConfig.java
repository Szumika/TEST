package com.example.start;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin@admin.pl")
            .password("{noop}admin")
            .roles("USER"); }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/films/*").permitAll()
                .antMatchers(HttpMethod.POST, "/film").permitAll()
                .antMatchers(HttpMethod.POST,"/film/{id}/actors*").permitAll()
                .antMatchers(HttpMethod.GET,"/master/*").permitAll()
                .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
                .anyRequest().authenticated();
    }
}
