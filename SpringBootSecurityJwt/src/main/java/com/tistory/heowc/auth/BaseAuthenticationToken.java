package com.tistory.heowc.auth;

import com.tistory.heowc.domain.Member;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public abstract class BaseAuthenticationToken extends AbstractAuthenticationToken {

	private Member member;
	
	public BaseAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
	}
	
	public BaseAuthenticationToken(Member member,
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.eraseCredentials();
		this.member = member;
		super.setAuthenticated(true);
	}

	public abstract Object getCredentials();

	@Override
	public Object getPrincipal() {
		return member;
	}
}
