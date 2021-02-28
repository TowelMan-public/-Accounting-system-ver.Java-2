package com.example.demo.select.expenses;

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

import com.example.demo.result.DeleteForm;
import com.example.demo.result.expenses.ExpensesForm;
import com.example.demo.security.login.UserDetailsImpl;

@Controller
@RequestMapping("/select/expenses")
public class Control {
	@Autowired
	SelectExpensesDatabaseMapper mapper;
	
	@ModelAttribute
	ExpensesForm expensesForm() {
		return new ExpensesForm();
	}
	
	@ModelAttribute
	DeleteForm deleteForm() {
		return new DeleteForm();
	}
	
	@GetMapping
	public String showDisplay(@ModelAttribute RequestForm form) {
		return "/select/expenses";
	}
	
	@PostMapping("result")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid RequestForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return "/select/expenses";
		//検索用フォーム作成
		SelectForm select = new SelectForm(form,user.getCompanyId());
		
		//検索の判別　検索の実行・セット・画面遷移
		if(select.isCheckGroup()) {//グループ検索
			//各種セットする
			model.addAttribute("ResultForm",mapper.selectGroup(select));
			model.addAttribute("selectItemName","経費");
			model.addAttribute("itemTypeName","経費の項目");
			model.addAttribute("haveItemType",select.isCheckGroupItem());
			//「日付のグループ指定は一つまでで「年ごと」の指定優先」で、SelectFormでやってるから、これでよい
			if(select.isCheckGroupMonth()) {
				model.addAttribute("haveDateType",true);
				model.addAttribute("dateType","年/月");
			}
			if(select.isCheckGroupYear()) {
				model.addAttribute("haveDateType",true);
				model.addAttribute("dateType","年");
			}
			return "/result/group";
		}else {//羅列検索
			model.addAttribute("ResultForm",mapper.selectList(select));
			return "/result/expenses";
		}
	}
}
