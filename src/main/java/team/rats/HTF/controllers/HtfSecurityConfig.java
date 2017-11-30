package team.rats.HTF.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@Configuration

public class HtfSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/index.html", "/assets/**").permitAll().and()
                //.authorizeRequests().antMatchers("/API/**").hasRole("patient").and()
                .formLogin().loginPage("/login").permitAll().and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .csrf().disable();
    }

    private static final String SQL_USERS_BY_USERNAME_QUERY =
            "SELECT user_name , password, true as enabled from db_spring_tf.user where `user_name` = ?;";

    private static final String SQL_AUTHORITIES_BY_USERNAME_QUERY =
            "SELECT user_name , user_type as role from db_spring_htf.user where `user_name` = ?;";

}
