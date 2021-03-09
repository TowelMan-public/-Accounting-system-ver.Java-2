package com.example.demo.controler.select;

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

import com.example.demo.dto.select.ExpensesItemDto;
import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.form.result.DeleteForm;
import com.example.demo.form.select.ExpensesItemForm;
import com.example.demo.repository.select.SelectExpensesItemMapper;

@Controller
@RequestMapping(ExpensesItemControl.PAGE_URL)
public class ExpensesItemControl {
	public static final String PAGE_URL = "/select/expensesItem";

	@Autowired
	SelectExpensesItemMapper mapper;

	@ModelAttribute
	ExpensesItemForm expensesItemForm() {
		return new ExpensesItemForm();
	}

	@ModelAttribute
	DeleteForm deleteForm() {
		return new DeleteForm();
	}

	@GetMapping
	public String showDisplay(@ModelAttribute ExpensesItemForm form) {
		return "/select/expensesItem";
	}

	@PostMapping("result")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid ExpensesItemForm form,
			BindingResult bindingResult, Model model) {
		// 入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return "/select/expensesItem";

		ExpensesItemDto select = new ExpensesItemDto(form, user.getCompanyId());
		// 今回は羅列検索のみ
		model.addAttribute("ResultForm", mapper.selectList(select));
		return "/result/expensesItem";
	}
}