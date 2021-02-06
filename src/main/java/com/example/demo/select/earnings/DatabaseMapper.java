package com.example.demo.select.earnings;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.select.GroupResultForm;
import com.example.demo.select.base.earnings.BaseDatabaseMapper;
import com.example.demo.select.base.earnings.ResultForm;
import com.example.demo.select.base.earnings.SelectForm;

@Mapper
public interface DatabaseMapper extends BaseDatabaseMapper {
	//グループ検索
	@Override
	List<GroupResultForm> selectGroup(SelectForm form);
	
	//普通に羅列の検索
	@Override
	List<ResultForm> selectList(SelectForm form);
}