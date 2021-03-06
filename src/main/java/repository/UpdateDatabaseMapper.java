package repository;

import org.apache.ibatis.annotations.Mapper;

import form.result.CompanyForm;
import form.result.EarningsForm;
import form.result.ExpensesForm;
import form.result.ExpensesItemForm;
import form.result.RevenueForm;

@Mapper
public interface UpdateDatabaseMapper {
	void updateCompany(CompanyForm form);
	void updateExpensesItem(ExpensesItemForm form);
	void updateExpenses(ExpensesForm form);
	void updateEarnings(EarningsForm form);
	void updateRevenue(RevenueForm form);
}