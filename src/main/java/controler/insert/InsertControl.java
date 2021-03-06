package controler.insert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(InsertControl.PAGE_URL)
public class InsertControl {
	public static final String PAGE_URL = "/insert";
	
	@GetMapping
	public String showDisplay(Model model) {
		return PAGE_URL;
	}
}