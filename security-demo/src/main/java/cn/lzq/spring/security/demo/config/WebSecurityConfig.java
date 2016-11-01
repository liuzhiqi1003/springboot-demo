package cn.lzq.spring.security.demo.config;

import cn.lzq.spring.security.demo.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-28 17:51
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    CustomUserService customUserService(){
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll()
                .and()
                .logout().permitAll();
    }
}
