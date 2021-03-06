package controler.insert;

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
import form.insert.CompanyForm;
import repository.InsertDatabaseMapper;

@Controller
@RequestMapping(CompanyControl.PAGE_URL)
public class CompanyControl {
	public static final String PAGE_URL = "/insert/company";
	private static final String REDIRECT_URL = "redirect;" + PAGE_URL;
	
	@Autowired
	InsertDatabaseMapper insertMapper;
	
	@GetMapping()
	public String showDisplay(@AuthenticationPrincipal UserDetailsImpl user, Model model, @ModelAttribute CompanyForm form) {		
		return PAGE_URL;
	}
	
	@PostMapping("insert")
	public String insert(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid CompanyForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		//formにcompanyAccountIdをセット
		form.setCompanyAccountId(user.getCompanyId());
		
		//追加
		insertMapper.insertCompany(form);
		return REDIRECT_URL;
	}
}