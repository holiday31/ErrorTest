package net.skhu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import net.skhu.service.MyAuthenticationProvider;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired MyAuthenticationProvider myAuthenticationProvider;

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/res/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
//        http.authorizeRequests()
//            .antMatchers("/").permitAll();

        http.csrf().disable();

//        http.formLogin()
//            .loginPage("/guest/login")
//            .loginProcessingUrl("/guest/login_processing")
//            .failureUrl("/guest/login?error")
//            .defaultSuccessUrl("/user/index", true)
//            .usernameParameter("loginId")
//            .passwordParameter("passwd");


        http.authenticationProvider(myAuthenticationProvider);
    }
}


