package br.com.recrutamento.brasilia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import br.com.recrutamento.brasilia.model.User;
import br.com.recrutamento.brasilia.repository.UserRepository;
import br.com.recrutamento.brasilia.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private UserRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
			
			User user = repository.findByUser(username);
		
			if(user == null) {
				throw new UsernameNotFoundException(username);
			}
			
		return new UserSS(user.getId(),user.getUser(), user.getPassword(), user.getRole());
	}

}
