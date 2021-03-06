package controler.insert;

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

import constant.VerificationMessage;
import entity.UserDetailsImpl;
import form.insert.ExpensesForm;
import repository.CandidateDatabaseMapper;
import repository.InsertDatabaseMapper;
import repository.VerificationDatabaseMapper;

@Controller
@RequestMapping(ExpensesControl.PAGE_URL)
public class ExpensesControl {
	public static final String PAGE_URL = "/insert/expenses";
	private static final String REDIRECT_URL = "redirect;" + PAGE_URL;
	
	@Autowired
	InsertDatabaseMapper insertMapper;
	@Autowired
	VerificationDatabaseMapper verificationMapper;
	@Autowired
	CandidateDatabaseMapper candidateMapper;
	
	@GetMapping()
	public String showDisplay(@AuthenticationPrincipal UserDetailsImpl user, Model model,@ModelAttribute ExpensesForm form) {	
		setCandidate(user,model);
		return PAGE_URL;
	}
	
	private void setCandidate(UserDetailsImpl user, Model model) {
		//候補を取得して、それをページにセット
		model.addAttribute("expensesItemCandidate",candidateMapper.getCandidateExpensesItem( user.getCompanyId() ));
	}
	
	@PostMapping("insert")
	public String insert(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid ExpensesForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors()) {
			setCandidate(user,model);
			return PAGE_URL;
		}
		
		//formにcompanyAccountIdをセット
		form.setCompanyAccountId(user.getCompanyId());
		
		//値の有効性をチェック
		if( !verificationMapper.isEnabledExpensesItemId(user.getCompanyId(), form.getExpensesItemToInteger())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "expensesItem", VerificationMessage.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//追加
		if (!bindingResult.hasErrors()) {//値がすべて有効
			insertMapper.insertExpenses(form);
			return REDIRECT_URL;
		}else {
			return PAGE_URL;
		}
	}
}