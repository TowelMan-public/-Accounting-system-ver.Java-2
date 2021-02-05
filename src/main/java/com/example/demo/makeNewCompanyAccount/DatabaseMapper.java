package com.example.demo.makeNewCompanyAccount;

import org.apache.ibatis.annotations.Mapper;

@Mapper//TODO 実装 変えるかもしれない
public interface DatabaseMapper {
	//新しい会社IDを取得する
	Integer getNewCompanyAccountId();

	//会社を登録する
	void insertCompanyAccount(CompanyAccountForm company);

	//新しいユーザーIDを取得する
	Integer getNewUserId();

	//ユーザーを登録する
	void insertUser(UserForm user);
	
}
