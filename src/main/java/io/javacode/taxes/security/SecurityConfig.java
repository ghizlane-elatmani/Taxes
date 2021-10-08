package io.javacode.taxes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
        auth.inMemoryAuthentication()
                .withUser("hassan")
                .password("{noop}123")
                .roles("ADMIN", "USER");

        auth.inMemoryAuthentication()
                .withUser("mohamed")
                .password("{noop}123")
                .roles("USER");
        */

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, pass as credentials, active from users where username=?")
                .authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder()); ;
    }

    // This is just for educational reason. Do not use it on a real project!
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login");

        /*
        * This line mean that every request needs an authentication
        * http.authorizeRequests().anyRequest().authenticated();
        */

        http.authorizeRequests()
                .antMatchers("/saveEntreprise", "/formEntreprise")
                .hasRole("ADMIN");

        http.authorizeRequests()
                .antMatchers("/entreprises", "/taxes")
                .hasRole("USER");

        http.exceptionHandling().accessDeniedPage("/403");
    }

}
