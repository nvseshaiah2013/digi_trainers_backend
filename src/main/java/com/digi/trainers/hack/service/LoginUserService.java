package com.digi.trainers.hack.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.digi.trainers.hack.repository.UserRepository;


@Service
public class LoginUserService implements UserDetailsService {

	@Autowired private UserRepository userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.digi.trainers.hack.model.User user = userDao.findByUsername(username);	
		if(user==null)
		{
			throw new UsernameNotFoundException(username);
		}
		else			
			return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}

}
