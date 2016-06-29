/**
 * 
 */
package com.lukeshannon.meetup.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 * @author lshannon
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/images", "/hello", "/login").permitAll()
				.anyRequest().authenticated().and().formLogin().and().logout().permitAll();
	}

	/**
	 * Notes:
	 * 1. Can override the queries
	 * 2. Can enable password encoding
	 * 3. Could have configured for LDAP
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
		  .jdbcAuthentication()
		   .dataSource(dataSource);
	}
	
	/**
	 * To configure both
	 */
	//@Bean
	//public UserDetailsService userDetailsService(DataSource dataSource) {
	 ///   JdbcUserDetailsManager uds = new JdbcUserDetailsManager();
	 //   uds.setDataSource(dataSource);
	//    return uds;
	//}

}
