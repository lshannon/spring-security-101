/**
 * 
 */
package com.lukeshannon.meetup.springsecurity.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author lshannon
 *
 */
@Component
public class CustomDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		if (userName != null && userName.equalsIgnoreCase("ninja")) {
			List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
		    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		    return new User(userName,"should look this up somewhere", true,true, true, true, authorities);
	}
		throw new UsernameNotFoundException("There is no '" + userName + "'");
	}

}
