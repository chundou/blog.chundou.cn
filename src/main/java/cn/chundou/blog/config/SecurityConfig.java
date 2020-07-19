package cn.chundou.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设置权限
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/auth/logout").hasAnyRole()
                .antMatchers("/uc/**").hasAnyRole("vip1", "vip2", "vip3")
                .antMatchers("/auth/**").permitAll()
                // .antMatchers("").hasAuthority("")
                .antMatchers("/vip1/**").hasRole("vip1")
                .antMatchers("/vip2/**").hasRole("vip2")
                .antMatchers("/vip1/**").hasRole("vip3");

        // 开启登录
        http.formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/uc");

        // 开启记住我，默认保存两周
        http.rememberMe().rememberMeParameter("rememberMe");

        // 开启注销
        http.logout().logoutSuccessUrl("/");

        // cors csrf
        http.cors().disable();
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        auth.inMemoryAuthentication()
                .withUser("root").password(passwordEncoder().encode("123456")).roles("vip1", "vip2", "vip3")
                .and()
                .withUser("vip1").password(passwordEncoder().encode("1234561")).roles("vip1")
                .and()
                .withUser("vip2").password(passwordEncoder().encode("1234562")).roles("vip2")
                .and()
                .withUser("vip3").password(passwordEncoder().encode("1234563")).roles("vip3");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 忽略静态资源鉴权
        web.ignoring().antMatchers("/static/**");
    }
}
