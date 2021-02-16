package com.example.demo.select.expensesItem;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelectExpensesItemDatabaseMapper {
	//普通に羅列の検索
	List<ResultForm> selectList(SelectForm form);
}
