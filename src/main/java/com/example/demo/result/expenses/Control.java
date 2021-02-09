package com.example.demo.result.expenses;

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
@RequestMapping("/result/expenses")
public class Control {
	@Autowired
	UpdateDatabaseMapper updateMapper;
	@Autowired
	DeleteDatabaseMapper deleteMapper;
	@Autowired
	VerificationDatabaseMapper verificationMapper;
	
	@PostMapping("update")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid ExpensesForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return "redirect:/result/expenses";
		
		//CompanyAccountIdをセットする
		form.setCompanyAccountId(user.getCompanyId());
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledExpensesId(user.getCompanyId(), form.getExpensesId())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "expensesId", Message.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		if( !verificationMapper.isEnabledExpensesItemId(user.getCompanyId(), form.getExpensesItem())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "expensesItemId", Message.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//更新して終了
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			updateMapper.updateExpenses(form);
		return "redirect:/result/expenses";
	}
	
	@PostMapping("delete")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid DeleteForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return "redirect:/result/expenses";
		
		//各IDが、有効かどうかをチェックする TODO
		if( !verificationMapper.isEnabledExpensesId(user.getCompanyId(), form.getIdToInt())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "id", Message.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//削除して終了
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			deleteMapper.deleteExpenses(user.getCompanyId(), form.getIdToInt());
		return "redirect:/result/expenses";
	}
}