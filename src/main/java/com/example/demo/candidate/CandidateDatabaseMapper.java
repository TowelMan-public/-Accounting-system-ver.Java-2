package com.example.demo.candidate;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper//TODO
public interface CandidateDatabaseMapper {
	//経費の項目の候補を取得する
	List<CandidateForm> getCandidateExpensesItem(@Param("companyAccountId")Integer id);
	
	//会社の候補を取得する
	List<CandidateForm> getCandidateCompany(@Param("companyAccountId")Integer id);
}
