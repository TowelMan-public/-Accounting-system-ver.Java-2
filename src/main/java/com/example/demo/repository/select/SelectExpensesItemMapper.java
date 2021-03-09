package com.example.demo.repository.select;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.select.ExpensesItemDto;
import com.example.demo.entity.select.ExpensesItemResultEntity;

@Mapper
public interface SelectExpensesItemMapper {
	//普通に羅列の検索
	List<ExpensesItemResultEntity> selectList(ExpensesItemDto form);
}
