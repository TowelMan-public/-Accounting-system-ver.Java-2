package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VerificationMapper {
	boolean isEnabledCompanyId(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
	boolean isEnabledExpensesItemId(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
	boolean isEnabledExpensesId(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
	boolean isEnabledEarningsId(@Param("companyAccountId") int companyAccountId, @Param("id") int id);
}
