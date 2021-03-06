package com.example.demo.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.Authority;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.form.MakeNewUserForm;
import com.example.demo.repository.MakeNewUserMapper;

@Controller
@RequestMapping(MakeNewUserControl.PAGE_URL)
public class MakeNewUserControl {	
	
	//定数群
	private static final String defaultAuthority = Authority.USER;
	public static final String PAGE_URL = "/makeNewUser";
	
	@Autowired
	MakeNewUserMapper mapper;
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping
	public String showDisplay(@ModelAttribute MakeNewUserForm form, Model model) {
		return PAGE_URL;
	}
	
	@PostMapping
	public String insertCompanyAccount(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid MakeNewUserForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		//ユーザーの登録
		UserDto newUser = new UserDto(form,encoder);
		newUser.setAuthority(defaultAuthority);
		newUser.setCompanyId( user.getCompanyId() );
		mapper.insertUser(newUser);
		
		//結果のセット
		model.addAttribute("id",newUser.getUserid());
		return "/resultMakeNewUser";
	}
}