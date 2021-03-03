package com.example.demo.result;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeleteDatabaseMapper {
	void deleteCompany(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
	void deleteExpensesItem(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
	void deleteExpenses(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
	void deleteEarnings(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
}
