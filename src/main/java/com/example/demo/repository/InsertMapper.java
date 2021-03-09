package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.form.insert.CompanyForm;
import com.example.demo.form.insert.EarningsForm;
import com.example.demo.form.insert.ExpensesForm;
import com.example.demo.form.insert.ExpensesItemForm;
import com.example.demo.form.insert.RevenueForm;

@Mapper
public interface InsertMapper {
	//会社の登録
	void insertCompany(CompanyForm form);
	
	//売上の登録 earningsIdに自動裁判のIDを取得すること
	void insertEarnings(EarningsForm form);
		
	//経費の登録
	void insertExpenses(ExpensesForm form);
	
	//収入の登録
	void insertRevenue(RevenueForm form);
	
	//経費の項目の登録
	void insertExpensesItem(ExpensesItemForm form);
}
