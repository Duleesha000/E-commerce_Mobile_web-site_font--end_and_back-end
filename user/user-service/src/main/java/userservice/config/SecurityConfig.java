package userservice.config;

import userservice.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Security detail object used by AuthenticationManager
     */
    @Autowired
    private DetailService detailService;

    /**
     * Exposes authenticationManagerBean for use in UserService
     * @return authenticationManagerBean
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Generates and exposes a BCrypt password encoder
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Sets up AuthenticationManager. Handled by container
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailService).passwordEncoder(passwordEncoder());
    }

    //TODO: development level configure(). Change before deploying.

    /**
     * Security detail on accessible endpoints
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/users/").permitAll()
                .antMatchers("/users/register").permitAll()
                .antMatchers("/users/logout").permitAll()
                .antMatchers("/users/update").permitAll()
                .anyRequest().authenticated();
    }
}
