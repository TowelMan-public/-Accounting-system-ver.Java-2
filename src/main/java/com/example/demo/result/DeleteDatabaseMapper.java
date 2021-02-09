package com.example.demo.result;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteDatabaseMapper {
	void deleteCompany(int companyAccountId, int id);
	void deleteExpensesItem(int companyAccountId, int id);
	void deleteExpenses(int companyAccountId, int id);
	void deleteEarnings(int companyAccountId, int id);
}
