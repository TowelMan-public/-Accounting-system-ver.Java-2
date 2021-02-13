package com.example.demo.makeNewUser;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.security.Authority;
import com.example.demo.security.login.UserDetailsImpl;

@Controller
@RequestMapping("/makeNewUser")
public class Control {	
	
	//定数群
	private final String defaultAuthority = Authority.user;
	
	@Autowired
	DatabaseMapper mapper;
	
	@GetMapping
	public String showDisplay(Model model) {
		return "/makeNewUser";
	}
	
	@PostMapping
	public String insertCompanyAccount(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid MakeNewUserForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return "redirect:/makeNewUser";
		
		//ユーザーの登録
		UserForm newUser = new UserForm(form);
		newUser.setAuthority(defaultAuthority);
		newUser.setCompanyId( user.getCompanyId() );
		mapper.insertUser(newUser);
		
		//結果のセット
		model.addAttribute("id",newUser.getUserid());
		return "redirect:/resultMakeNewUser";
	}
}