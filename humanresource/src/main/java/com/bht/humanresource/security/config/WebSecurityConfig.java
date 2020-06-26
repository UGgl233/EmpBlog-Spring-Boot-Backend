package com.bht.humanresource.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@CrossOrigin
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        //Authorization
//        http.authorizeRequests().antMatchers("/", "/signup", "/login", "/logout").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "app/employees/**").permitAll();
//        http.authorizeRequests().antMatchers("app/employee/**")
//                .access("hasAnyRole('ADMIN')");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "app/employee")
                .access("hasAnyRole('ADMIN', 'USER')");

        //access denied page
/*
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/accessdeny");
*/

        //Login
/*        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/security_login")  //login submission url
                .loginPage("/login")  //load login page
                .defaultSuccessUrl("/userInfo")  //if login success
                .failureUrl("/login?error=true") //if login fail
                .usernameParameter("email")  //login form user email when submission
                .passwordParameter("password"); //login form user password when submission*/

//        http.authorizeRequests().and().formLogin();

        http
                .authorizeRequests()
                .anyRequest().authenticated()  // (1)
                .and()
                .formLogin()
                /*
                * 似乎需要实现 RestAuthEntryPoint implements AuthenticationEntryPoint
                * 然后在 httpBasic之后 加上
                * .authenticationEntryPoint(authenticationEntryPoint);
                * 才可以支持restful api的访问？？？
                * */
                .defaultSuccessUrl("/")
                .and()   // (2)
                .httpBasic();  // (3)

        //Logout
/*
        http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
*/
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
