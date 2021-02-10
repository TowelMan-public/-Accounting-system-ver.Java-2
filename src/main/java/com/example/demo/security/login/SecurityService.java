package com.example.demo.security.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.RegexpPattern;

@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	private DatabaseMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException { 
		Form outPut=new Form();
		if(userId.matches(RegexpPattern.INTEGER))
			outPut = mapper.selectById(Integer.parseInt(userId));
		if(outPut == null) {
            throw new UsernameNotFoundException(userId + " is not found");
        }
		return new UserDetailsImpl(outPut);
	}

}
