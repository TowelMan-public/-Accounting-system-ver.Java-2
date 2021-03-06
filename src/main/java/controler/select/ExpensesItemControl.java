package controler.select;

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

import dto.select.expensesItemDto;
import entity.UserDetailsImpl;
import form.result.DeleteForm;
import form.result.ExpensesItemForm;
import repository.select.SelectExpensesItemDatabaseMapper;

@Controller
@RequestMapping(ExpensesItemControl.PAGE_URL)
public class ExpensesItemControl {
	public static final String PAGE_URL = "/select/expensesItem";

	@Autowired
	SelectExpensesItemDatabaseMapper mapper;

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

		expensesItemDto select = new expensesItemDto(form, user.getCompanyId());
		// 今回は羅列検索のみ
		model.addAttribute("ResultForm", mapper.selectList(select));
		return "/result/expensesItem";
	}
}