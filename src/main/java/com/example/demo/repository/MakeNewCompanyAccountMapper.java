package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.CompanyAccountEntity;

@Mapper
public interface MakeNewCompanyAccountMapper {
	//新しい会社IDを取得する
	void getNewCompanyAccountId(CompanyAccountEntity company);

	//会社を登録する
	void insertCompanyAccount(CompanyAccountEntity company);
	
	//ユーザーを登録する
	void insertUser(UserDto user);
	
}