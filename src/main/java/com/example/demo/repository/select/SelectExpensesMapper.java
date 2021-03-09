package com.example.demo.repository.select;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.select.ExpensesDto;
import com.example.demo.entity.select.ExpensesResultEntity;
import com.example.demo.entity.select.GroupResultEntity;

@Mapper
public interface SelectExpensesMapper {
	//グループ検索
	List<GroupResultEntity> selectGroup(ExpensesDto form);
	
	//普通に羅列の検索
	List<ExpensesResultEntity> selectList(ExpensesDto form);
}
