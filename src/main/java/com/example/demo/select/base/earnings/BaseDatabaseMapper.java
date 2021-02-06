package com.example.demo.select.base.earnings;

import java.util.List;

import com.example.demo.select.GroupResultForm;

public interface BaseDatabaseMapper {
	//グループ検索
	List<GroupResultForm> selectGroup(SelectForm form);
	
	//普通に羅列の検索
	List<ResultForm> selectList(SelectForm form);
}
