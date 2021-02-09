package com.example.demo.result.earnings;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.result.DeleteDatabaseMapper;
import com.example.demo.result.DeleteForm;
import com.example.demo.result.UpdateDatabaseMapper;
import com.example.demo.security.login.UserDetailsImpl;
import com.example.demo.verification.Message;
import com.example.demo.verification.VerificationDatabaseMapper;

@Controller
@RequestMapping("/result/earnings")
public class Control {
	@Autowired
	UpdateDatabaseMapper updateMapper;
	@Autowired
	DeleteDatabaseMapper deleteMapper;
	@Autowired
	VerificationDatabaseMapper verificationMapper;
	
	@PostMapping("update")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid EarningsForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return "redirect:/result/earnings";
		
		//CompanyAccountIdをセットする
		form.setCompanyAccountId(user.getCompanyId());
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledEarningsId(user.getCompanyId(), form.getEarningsId())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "earningsId", Message.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		if( !verificationMapper.isEnabledCompanyId(user.getCompanyId(), form.getCompany())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "company", Message.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//更新して終了
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			updateMapper.updateEarnings(form);
		return "redirect:/result/earnings";
	}
	
	@PostMapping("delete")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid DeleteForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return "redirect:/result/earnings";
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledEarningsId(user.getCompanyId(), form.getIdToInt())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "id", Message.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//削除して終了
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			deleteMapper.deleteEarnings(user.getCompanyId(), form.getIdToInt());
		return "redirect:/result/earnings";
	}
}