package com.example.demo.result;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.result.company.CompanyForm;
import com.example.demo.result.earnings.EarningsForm;
import com.example.demo.result.expenses.ExpensesForm;
import com.example.demo.result.expensesItem.ExpensesItemForm;
import com.example.demo.result.revenue.RevenueForm;

@Mapper
public interface UpdateDatabaseMapper {
	void updateCompany(CompanyForm form);
	void updateExpensesItem(ExpensesItemForm form);
	void updateExpenses(ExpensesForm form);
	void updateEarnings(EarningsForm form);
	void updateRevenue(RevenueForm form);
}