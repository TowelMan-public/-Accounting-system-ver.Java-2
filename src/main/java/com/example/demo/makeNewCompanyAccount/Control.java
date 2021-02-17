package com.example.demo.makeNewCompanyAccount;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.security.Authority;

@Controller
@RequestMapping("/makeNewCompanyAccount")
public class Control {	
	//定数群
	private final String defaultAuthority = Authority.master;
	
	@Autowired
	MakeNewCompanyAccountDatabaseMapper mapper;
	
	@GetMapping
	public String showDisplay( MakeNewComanyAccountForm form,Model model) {
		return "/makeNewCompanyAccount";
	}
	@PostMapping("make")
	public String insertCompanyAccount(@Valid MakeNewComanyAccountForm form,BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return "/makeNewCompanyAccount";
		
		//各種Formオブジェクト作成
		UserForm user = new UserForm(form);
		CompanyAccountForm company = new CompanyAccountForm(form);
		
		//会社の登録
		mapper.getNewCompanyAccountId(company);
		mapper.insertCompanyAccount(company);
		
		//ユーザーの登録
		user.setAuthority(defaultAuthority);
		user.setCompanyId( company.getCompanyId() );
		mapper.insertUser(user);
		
		//結果のセット
		model.addAttribute("userId",user.getUserid());
		model.addAttribute("companyId",user.getCompanyId());
		return "redirect:/resultMakeNewCompanyAccount";
	}
}