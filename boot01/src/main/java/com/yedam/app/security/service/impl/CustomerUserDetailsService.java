package com.yedam.app.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yedam.app.security.service.LoginUserVO;

public class CustomerUserDetailsService implements UserDetailsService{
	private UserMapper usermapper;
	
	@Autowired
	CustomerUserDetailsService(UserMapper usermapper){
		this.usermapper = usermapper;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Mapper를 활용해서 DB에 접근
		UserVO userVO = usermapper.getUserInfo(username);
		
		if(userVO == null) {
			throw new UsernameNotFoundException(username);
		}
		return new LoginUserVO(userVO);
	}

}
