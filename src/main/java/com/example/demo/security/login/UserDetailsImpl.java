package com.example.demo.security.login;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -256740067874995659L;
	
	private Form user;
	
	//コンストラクタ
	public UserDetailsImpl(Form account){
		this.user = account;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(user.getAuthority());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	//実際にはユーザーIDを取得する（フレームワークの都合）
	@Override
	public String getUsername() {
		return user.getUserId().toString();
	}
	
	//ユーザー名取得
	public String getAccountUserName() {
		return user.getUserId().toString();
	}
	
	//会社ID取得
	public String getCompanyId() {
		return user.getCompanyId().toString();
	}
	
	//会社名取得
	public String getCompanyName() {
		return user.getCompanyName();
	}	
	
	//アカウントの有効期限の状態を判定
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//アカウントのロック状態を判定
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//資格情報の有効期限の状態を判定
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//有効なユーザーかどうか
	@Override
	public boolean isEnabled() {
		return true;
	}

}
