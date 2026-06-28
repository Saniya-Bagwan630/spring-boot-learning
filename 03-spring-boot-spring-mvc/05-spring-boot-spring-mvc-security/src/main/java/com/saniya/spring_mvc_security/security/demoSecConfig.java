package com.saniya.spring_mvc_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class demoSecConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id =?");
        return jdbcUserDetailsManager;
    }

    //custom login form
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->
                configure
                        //ristricting url based on role
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")


                        .anyRequest().authenticated()

        )


                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage") //form will be shown on this url
                                .loginProcessingUrl("/authenticateTheUser") // form will be posted to this url       fun part : we need not to provide postmapping for this
                                .permitAll()
                        )
                .logout(logout -> logout.permitAll())//logout


                .exceptionHandling(configure ->
                        configure.accessDeniedPage("/access-denied") // acess denied page
                );

        return http.build();
    }
}
