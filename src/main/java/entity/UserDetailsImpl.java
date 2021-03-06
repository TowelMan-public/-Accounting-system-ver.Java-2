package entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import form.LoginForm;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -256740067874995659L;
	
	private LoginForm user;
	
	//コンストラクタ
	public UserDetailsImpl(LoginForm account){
		this.user = account;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(user.getAuthority());
	}

	public String getAuthoritie() {
		return user.getAuthority();
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
		return user.getUserName();
	}
	
	//会社ID取得
	public Integer getCompanyId() {
		return user.getCompanyId();
	}
	
	//会社名取得
	public String getCompanyName() {
		return user.getCompanyName();
	}	
	
	//会社名のセット
	public void setCompanyName(String cmpanyName) {
		this.user.setCompanyName(cmpanyName);
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
