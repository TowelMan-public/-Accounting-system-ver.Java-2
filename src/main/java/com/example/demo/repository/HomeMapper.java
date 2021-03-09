package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeMapper {
	//「今月」の売上を取得
	Integer getEarningsMonth(int companyId);
	
	//「今月」の経費を取得
	Integer getEexpensesMonth(int companyId);
	
	//「今年」の売上を取得
	Integer getEarningsYear(int companyId);
	
	//「今年」の経費を取得
	Integer getExpensesYear(int companyId);
		
	//「今年」の純利益を取得
	Integer getNetIncomeYear(int companyId);
}
