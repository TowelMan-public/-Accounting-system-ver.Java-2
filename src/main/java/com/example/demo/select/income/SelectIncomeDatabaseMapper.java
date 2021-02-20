package com.example.demo.select.income;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.select.GroupResultForm;
import com.example.demo.select.base.earningsGroup.BaseDatabaseMapper;
import com.example.demo.select.base.earningsGroup.SelectForm;

@Mapper
public interface SelectIncomeDatabaseMapper extends BaseDatabaseMapper {
	//グループ検索
	@Override
	List<GroupResultForm> selectGroup(SelectForm form);
}