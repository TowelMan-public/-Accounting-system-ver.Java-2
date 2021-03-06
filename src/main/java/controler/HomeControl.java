package controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.UserDetailsImpl;
import repository.HomeDatabaseMapper;

@Controller
@RequestMapping(HomeControl.PAGE_URL)
public class HomeControl {
	public static final String PAGE_URL = "/home";
	
	@Autowired
	HomeDatabaseMapper mapper;
	
	@GetMapping
	public String showDisplay(@AuthenticationPrincipal UserDetailsImpl user, Model model) {		
		//最初の案内文セット
		model.addAttribute("companyName",user.getCompanyName());
		model.addAttribute("userName",user.getAccountUserName());
		
		//「今月」の情報をセット
		model.addAttribute("earningsMonth", mapper.getEarningsMonth( user.getCompanyId() ) );
		model.addAttribute("expensesMonth", mapper.getEexpensesMonth( user.getCompanyId() ) );
		
		//今年の情報をセット
		model.addAttribute("earningsYear", mapper.getEarningsYear( user.getCompanyId() ) );
		model.addAttribute("expensesYear", mapper.getExpensesYear( user.getCompanyId() ) );
		model.addAttribute("netIncomeRateYear", mapper.getNetIncomeYear( user.getCompanyId() ) );
		
		return PAGE_URL;
	}
}