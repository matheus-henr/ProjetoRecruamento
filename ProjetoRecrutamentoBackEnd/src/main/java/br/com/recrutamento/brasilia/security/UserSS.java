package br.com.recrutamento.brasilia.security;

import java.util.Arrays;
import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.recrutamento.brasilia.model.enums.Role;

public class UserSS implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String user;
	private String password;
	private Collection< ? extends GrantedAuthority> authorities;
	
	
	
	public UserSS() {}
	
	
	public UserSS(Integer id, String user, String password, Role role) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.authorities = Arrays.asList(new SimpleGrantedAuthority(role.getDescrption()));
				
	}


	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return user;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
