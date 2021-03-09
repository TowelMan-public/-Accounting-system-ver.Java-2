package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.form.result.CompanyForm;
import com.example.demo.form.result.EarningsForm;
import com.example.demo.form.result.ExpensesForm;
import com.example.demo.form.result.ExpensesItemForm;
import com.example.demo.form.result.RevenueForm;

@Mapper
public interface UpdateMapper {
	void updateCompany(CompanyForm form);
	void updateExpensesItem(ExpensesItemForm form);
	void updateExpenses(ExpensesForm form);
	void updateEarnings(EarningsForm form);
	void updateRevenue(RevenueForm form);
}