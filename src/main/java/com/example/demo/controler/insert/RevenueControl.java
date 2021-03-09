package com.example.demo.controler.insert;

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

import com.example.demo.constant.VerificationMessage;
import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.form.insert.RevenueForm;
import com.example.demo.repository.CandidateMapper;
import com.example.demo.repository.InsertMapper;
import com.example.demo.repository.VerificationMapper;

@Controller
@RequestMapping(RevenueControl.PAGE_URL)
public class RevenueControl {
	public static final String PAGE_URL = "/insert/revenue";
	private static final String REDIRECT_URL = "redirect;" + PAGE_URL;
	
	@Autowired
	InsertMapper insertMapper;
	@Autowired
	VerificationMapper verificationMapper;
	@Autowired
	CandidateMapper candidateMapper;
	
	@GetMapping()
	public String showDisplay(@AuthenticationPrincipal UserDetailsImpl user, Model model,@ModelAttribute RevenueForm form) {	
		return PAGE_URL;
	}
	
	@PostMapping("insert")
	public String insert(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid RevenueForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		//formにcompanyAccountIdをセット
		form.setCompanyAccountId(user.getCompanyId());
		
		//値の有効性をチェック
		if( !verificationMapper.isEnabledEarningsId(user.getCompanyId(), form.getEarningsIdToInteger())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "earningsId", VerificationMessage.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//追加
		if (!bindingResult.hasErrors()) {//値がすべて有効
			insertMapper.insertRevenue(form);
		}
		return REDIRECT_URL;
	}
}