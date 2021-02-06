package com.example.demo.select.expenses;

import java.util.List;

import com.example.demo.select.GroupResultForm;

public interface DatabaseMapper {
	//グループ検索
	List<GroupResultForm> selectGroup(SelectForm form);
	
	//普通に羅列の検索
	List<ResultForm> selectList(SelectForm form);
}
