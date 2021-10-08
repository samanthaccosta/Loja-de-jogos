package br.org.generation.shopgame.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.org.generation.shopgame.model.Usuario;
/* Implementa a interface UserDetails, que descreve o usuário para o Spring Security,
 * ou seja, detalha as caracteríticas e direitos do usuário.*/
public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID= 1L;
	private String userName;
	private String password;
	private List<GrantedAuthority> authoritie;
	
	// Método construtor com parâmetros
	public UserDetailsImpl(Usuario usuario) {
		this.userName=usuario.getUsuario();
		this.password= usuario.getSenha();
	}
	// Método construtor sem parâmetros
		public UserDetailsImpl() {	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authoritie;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
