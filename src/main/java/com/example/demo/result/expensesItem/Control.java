package com.example.demo.result.expensesItem;

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
import com.example.demo.result.expenses.ExpensesForm;
import com.example.demo.security.login.UserDetailsImpl;
import com.example.demo.select.expensesItem.RequestForm;
import com.example.demo.select.expensesItem.SelectExpensesItemDatabaseMapper;
import com.example.demo.select.expensesItem.SelectForm;
import com.example.demo.verification.Message;
import com.example.demo.verification.VerificationDatabaseMapper;

@Controller
@RequestMapping("/result/expensesItem")
public class Control {
	@Autowired
	UpdateDatabaseMapper updateMapper;
	@Autowired
	DeleteDatabaseMapper deleteMapper;
	@Autowired
	VerificationDatabaseMapper verificationMapper;
	@Autowired
	SelectExpensesItemDatabaseMapper selectMapper;
	
	@ModelAttribute
	ExpensesItemForm expensesItemForm() {
		return new ExpensesItemForm();
	}
	
	@ModelAttribute
	DeleteForm deleteForm() {
		return new DeleteForm();
	}
	
	@PostMapping("update")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid ExpensesItemForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return "/result/expensesItem";
		
		//CompanyAccountIdをセットする
		form.setCompanyAccountId(user.getCompanyId());
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledExpensesItemId(user.getCompanyId(), form.getExpensesItemIdToInteger())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "expensesItemId", Message.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//更新して終了
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			updateMapper.updateExpensesItem(form);
		return "/result/expensesItem";
	}
	
	@PostMapping("delete")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid DeleteForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return "/result/expensesItem";
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledExpensesItemId(user.getCompanyId(), form.getIdToInt())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "id", Message.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//削除して終了
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			deleteMapper.deleteExpensesItem(user.getCompanyId(), form.getIdToInt());
		
		SelectForm select = new SelectForm(new RequestForm(),user.getCompanyId());
		model.addAttribute("ResultForm",selectMapper.selectList(select));
		
		return "/result/expensesItem";
	}
}