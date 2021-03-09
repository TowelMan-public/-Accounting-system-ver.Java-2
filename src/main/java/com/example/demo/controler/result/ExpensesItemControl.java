package com.example.demo.controler.result;

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

import com.example.demo.constant.VerificationMessage;
import com.example.demo.dto.select.ExpensesItemDto;
import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.form.result.DeleteForm;
import com.example.demo.form.result.ExpensesItemForm;
import com.example.demo.repository.DeleteMapper;
import com.example.demo.repository.UpdateMapper;
import com.example.demo.repository.VerificationMapper;
import com.example.demo.repository.select.SelectExpensesItemMapper;

@Controller
@RequestMapping(ExpensesItemControl.PAGE_URL)
public class ExpensesItemControl {
	public static final String PAGE_URL = "/result/expensesItem";
	
	@Autowired
	UpdateMapper updateMapper;
	@Autowired
	DeleteMapper deleteMapper;
	@Autowired
	VerificationMapper verificationMapper;
	@Autowired
	SelectExpensesItemMapper selectMapper;
	
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
			return PAGE_URL;
		
		//CompanyAccountIdをセットする
		form.setCompanyAccountId(user.getCompanyId());
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledExpensesItemId(user.getCompanyId(), form.getExpensesItemIdToInteger())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "expensesItemId", VerificationMessage.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//更新して終了
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			updateMapper.updateExpensesItem(form);
		return PAGE_URL;
	}
	
	@PostMapping("delete")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid DeleteForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledExpensesItemId(user.getCompanyId(), form.getIdToInt())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "id", VerificationMessage.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//削除して終了
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			deleteMapper.deleteExpensesItem(user.getCompanyId(), form.getIdToInt());
		
		ExpensesItemDto select = new ExpensesItemDto(user.getCompanyId());
		model.addAttribute("ResultForm",selectMapper.selectList(select));
		
		return PAGE_URL;
	}
}