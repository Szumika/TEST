package com.example.start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //    @Autowired
//    DataSource dataSource;
//
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT `email`,`passwordhash`,`active` FROM `users` WHERE `email`=?")
                .authoritiesByUsernameQuery("SELECT `email` FROM `users` WHERE `email`=?")
                .passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


//    @Override protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception { auth.inMemoryAuthentication()
//            .withUser("admin@admin.pl")
//            .password("{noop}admin")
//            .roles("USER"); }

//
//            @Override
//    public void configure(HttpSecurity http) throws Exception {
//                http
//                        .authorizeRequests().antMatchers("/ oauth / token", "/ oauth / authorize **", "/ publishes").permitAll();
//            }
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/").access("hasRole( 'ROLE_USER')")
//                .antMatchers(HttpMethod.POST,"/films/*").permitAll()
//                .antMatchers(HttpMethod.POST, "/film").permitAll()
//                .antMatchers(HttpMethod.GET,"/film/{id}").permitAll()
//                .antMatchers(HttpMethod.POST,"/film/{id}/actors").permitAll()
//                .antMatchers(HttpMethod.GET,"/film/{id}/actors").permitAll()
//                .antMatchers(HttpMethod.GET,"/master/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
//                .anyRequest().authenticated();
//    }

//    @Bean(name = "passwordEncoder")
//    public PasswordEncoder passwordencoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
}
