package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeleteMapper {
	void deleteCompany(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
	void deleteExpensesItem(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
	void deleteExpenses(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
	void deleteEarnings(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
}
