package org.carpetati.spring.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "org.carpetati.spring.*" })
public class SecurityWeb extends WebSecurityConfigurerAdapter {
	
	@Autowired 	private ComboPooledDataSource dataSource;
	
	@Override
 	public void configure(WebSecurity web) throws Exception {
		// Spring Security should completely ignore URLs starting with /resources/
 		web.ignoring().antMatchers("/resources/**");
 	}
	
	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		//enable in memory based authentication with a user named "user" and "admin"
 		/*auth.inMemoryAuthentication()
 			.withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
 			.and().withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");*/
 		
 		auth.jdbcAuthentication().dataSource(dataSource)
 		.usersByUsernameQuery("select username, password, enabled from users where username=?")
 		.authoritiesByUsernameQuery("SELECT u.username username, r.nombre role FROM users as u inner join roles as r on(u.idrol=r.id) where u.username=?");
 	}
	
 	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.csrf().disable();
 		http.authorizeRequests().antMatchers("/login", "/logout").permitAll();
 		http.authorizeRequests().antMatchers("/**").hasAnyAuthority("ADMIN", "USERS", "CONSULTA");
 		
 		http.authorizeRequests().and().formLogin()
 		.loginPage("/login").usernameParameter("username").passwordParameter("password")
 		.defaultSuccessUrl("/movactivos")
 		.failureUrl("/login?error=true")
 		.and().logout().logoutUrl("/logout");
 	}
 	
 	@Bean
 	public PasswordEncoder passwordEncoder() {
 		return new BCryptPasswordEncoder();
 	}

}