package com.example.demo.verification;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VerificationDatabaseMapper {
	boolean isEnabledCompanyId(int companyAccountId, int id);
	boolean isEnabledExpensesItemId(int companyAccountId, int id);
	boolean isEnabledExpensesId(int companyAccountId, int id);
	boolean isEnabledEarningsId(int companyAccountId, int id);
}
