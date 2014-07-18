package com.newad.realestate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.newad.realestate.security.PathLoginAuthenticationEntryPoint;
import com.newad.realestate.security.PathUrlAuthenticationFailureHandler;
import com.newad.realestate.security.PathUrlLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PathLoginAuthenticationEntryPoint loginEntryPoint;

    @Autowired
    PathUrlAuthenticationFailureHandler loginFailureHandler;

    @Autowired
    PathUrlLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    DataSource dataSource;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//            .antMatchers("/**").permitAll()
//            .and()
//            .formLogin().loginPage("/login").failureUrl("/login?error")
//            .loginProcessingUrl("/j_spring_security_check")
//            .usernameParameter("j_username").passwordParameter("j_password")        
//            .and()
//            .logout().logoutSuccessUrl("/login?logout")
//            .and()
//            .csrf().disable();
//        http.csrf().disable()
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and()
            .formLogin()
                .loginProcessingUrl("/newad-login")
                .usernameParameter("j_username").passwordParameter("j_password")
                .failureHandler(loginFailureHandler)
                .and()
            .logout()
                .logoutUrl("/newad-logout")
                .and()
            .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(1209600);

        http.logout().logoutSuccessHandler(logoutSuccessHandler);
        http.exceptionHandling().authenticationEntryPoint(loginEntryPoint);
        http.exceptionHandling().accessDeniedPage("/accessDenied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/static/**");
    }
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

}
