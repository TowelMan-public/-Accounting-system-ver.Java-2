package com.example.demo.home;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper//TODO 実装
public interface DatabaseMapper {
	//「今月」の売上を取得
	String getEarningsMonth(@Param("companyId") int companyId);
	
	//「今月」の経費を取得
	String getEexpensesMonth(@Param("companyId") int companyId);
	
	//「今月」の純利益を取得
	String getNetIncomeRateMonth(@Param("companyId") int companyId);
	
	//「今年」の売上を取得
	String getEarningsYear(@Param("companyId") int companyId);
	
	//「今年」の経費を取得
	String getExpensesYear(@Param("companyId") int companyId);
		
	//「今年」の純利益を取得
	String getNetIncomeRateYear(@Param("companyId") int companyId);
}
