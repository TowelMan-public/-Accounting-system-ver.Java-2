package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import constant.RegexpPattern;
import entity.UserDetailsImpl;
import form.LoginForm;
import repository.LoginDatabaseMapper;

@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	private LoginDatabaseMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException { 
		LoginForm outPut=new LoginForm();
		if(userId.matches(RegexpPattern.INTEGER))
			outPut = mapper.selectById(Integer.parseInt(userId));
		if(outPut == null) {
            throw new UsernameNotFoundException(userId + " is not found");
        }
		return new UserDetailsImpl(outPut);
	}

}
