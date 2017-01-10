


Basic blog system built with Spring MVC. Edit/Add posts, register/login. Updated regulary.



## Install

```

```
Run with Spring boot to test



## Usage

```
package com.webstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.webstore.services.user.UserDetailServiceImpl;
import com.webstore.services.user.UserInnerRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	// Give this bean for the spring security to handle users for authority
	@Autowired
    private UserDetailServiceImpl userDetailsService;
	
	@Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
	
	@Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/fonts/**", "/img/**", "/css/**", "/js/**", "/users/register").permitAll() // Do i need to write this all ? Is there shorter way
			.antMatchers("/admin/**").hasAuthority("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/users/login")
				.permitAll()
				.and()
			.logout()
			.permitAll().and()
			.sessionManagement().maximumSessions(1)
			.sessionRegistry(sessionRegistry());
			
			
			;
		
		
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService)
		
		; // This is just a test will be changed later
		
		
	}
	
	

}

```


## License

NightPlex © [Steven Tihomirov](https://)
