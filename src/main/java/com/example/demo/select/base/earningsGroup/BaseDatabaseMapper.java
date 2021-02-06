package com.example.demo.select.base.earningsGroup;

import java.util.List;

import com.example.demo.select.GroupResultForm;

public interface BaseDatabaseMapper {
	//グループ検索
	List<GroupResultForm> selectGroup(com.example.demo.select.base.earningsGroup.SelectForm select);
}
