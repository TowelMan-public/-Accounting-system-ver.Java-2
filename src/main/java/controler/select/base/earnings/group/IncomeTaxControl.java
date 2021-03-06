package controler.select.base.earnings.group;

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

import entity.UserDetailsImpl;
import form.select.BaseEarningsGroupForm;
import repository.select.base.earnings.group.SelectIncomeTaxDatabaseMapper;

@Controller
@RequestMapping("/select/incomeTax")
public class IncomeTaxControl extends BaseControl{
	
	@Autowired
	SelectIncomeTaxDatabaseMapper mapper;
	
	@GetMapping
	public String showDisplay(@ModelAttribute BaseEarningsGroupForm form) {
		return "/select/incomeTax";
	}
	
	@PostMapping("result")
	@Override
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid BaseEarningsGroupForm form, BindingResult bindingResult, Model model) {
		super.datebaceMapper = mapper;
		super.groupItemName = "所得税";
		super.groupItemTypeName="会社";
		super.selectUrl = "incomeTax";
		
		return super.select(user, form, bindingResult, model);
	}
}