package com.example.demo.insert.revenue;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.candidate.CandidateDatabaseMapper;
import com.example.demo.insert.InsertDatabaseMapper;
import com.example.demo.security.login.UserDetailsImpl;
import com.example.demo.verification.Message;
import com.example.demo.verification.VerificationDatabaseMapper;

@Controller
@RequestMapping("/insert/revenue")
public class Control {
	@Autowired
	InsertDatabaseMapper insertMapper;
	@Autowired
	VerificationDatabaseMapper verificationMapper;
	@Autowired
	CandidateDatabaseMapper candidateMapper;
	
	@GetMapping()
	public String showDisplay(@AuthenticationPrincipal UserDetailsImpl user, Model model) {	
		return "/insert/revenue";
	}
	
	@PostMapping("insert")
	public String insert(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid RevenueForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return "redirect:/result/revenue";
		
		//formにcompanyAccountIdをセット
		form.setCompanyAccountId(user.getCompanyId());
		
		//値の有効性をチェック
		if( !verificationMapper.isEnabledEarningsId(user.getCompanyId(), form.getEarningsId())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "earningsId", Message.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//追加
		if (!bindingResult.hasErrors()) {//値がすべて有効
			insertMapper.insertRevenue(form);
		}
		return "/insert/revenue";
	}
}