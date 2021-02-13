package com.example.demo.select.base.earnings;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import com.example.demo.security.login.UserDetailsImpl;

public class BaseControl {//extends
	protected BaseDatabaseMapper datebaceMapper;
	protected String groupItemName;
	protected String groupItemTypeName;
	protected String selectUrl;
	
	public BaseControl() {
		datebaceMapper = null;
		groupItemName = null;
		groupItemTypeName = null;
		selectUrl = null;
	}
	
	public String select (UserDetailsImpl user, RequestForm form, BindingResult bindingResult, Model model)throws NullPointerException {
		//初期化されているかチェック
		this.checkInitialized();
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return "redirect:/select/" + selectUrl;
		//検索用フォーム作成
		SelectForm select = new SelectForm(form,user.getCompanyId());
		
		//検索の判別　検索の実行・セット・画面遷移
		if(select.isCheckGroup()) {//グループ検索
			//各種セットする
			model.addAttribute("ResultForm",datebaceMapper.selectGroup(select));
			model.addAttribute("selectItemName",groupItemName);
			model.addAttribute("itemTypeName",groupItemTypeName);
			model.addAttribute("haveItemType",select.isCheckGroupItem());
			//「日付のグループ指定は一つまでで「年ごと」の指定優先」で、SelectFormでやってるから、これでよい
			if(select.isCheckGroupMonth()) {
				model.addAttribute("haveDateType",true);
				model.addAttribute("dateType","年/月");
			}
			if(select.isCheckGroupYear()) {
				model.addAttribute("haveDateType","true");
				model.addAttribute("dateType","年");
			}
			return "redirect:/result/group";
		}else {//羅列検索
			model.addAttribute("ResultForm",datebaceMapper.selectList(select));
			return "redirect:/result/" + selectUrl;
		}
	}
	
	private void checkInitialized() throws NullPointerException{
		if(datebaceMapper == null || groupItemName == null ||
				groupItemTypeName == null || selectUrl == null)
			throw new NullPointerException();
	}
}