package com.example.demo.makeNewCompanyAccount;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MakeNewCompanyAccountDatabaseMapper {
	//新しい会社IDを取得する
	void getNewCompanyAccountId(CompanyAccountForm company);

	//会社を登録する
	void insertCompanyAccount(CompanyAccountForm company);
	
	//ユーザーを登録する
	void insertUser(UserForm user);
	
}