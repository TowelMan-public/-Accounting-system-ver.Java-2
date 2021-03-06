package repository.select.base.earnings.group;

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

import controler.select.base.earnings.group.BaseControl;
import entity.UserDetailsImpl;
import form.result.RevenueForm;
import form.select.BaseEarningsGroupForm;

@Controller
@RequestMapping("/select/income")
public class IncomeControl extends BaseControl{
	
	@Autowired
	SelectIncomeDatabaseMapper mapper;
	
	@ModelAttribute
	RevenueForm revenueForm() {
		return new RevenueForm();
	}
	
	@GetMapping
	public String showDisplay(@ModelAttribute BaseEarningsGroupForm form) {
		return "/select/income";
	}
	
	@PostMapping("result")
	@Override
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid BaseEarningsGroupForm form, BindingResult bindingResult, Model model) {
		super.datebaceMapper = mapper;
		super.groupItemName = "所得";
		super.groupItemTypeName="会社";
		super.selectUrl = "income";
		
		return super.select(user, form, bindingResult, model);
	}
}