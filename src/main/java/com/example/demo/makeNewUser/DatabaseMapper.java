package com.example.demo.makeNewUser;

import org.apache.ibatis.annotations.Mapper;

@Mapper//TODO 実装 変えるかもしれない
public interface DatabaseMapper {
	//新しいユーザーIDを取得する
	Integer getNewUserId();

	//ユーザーを登録する
	void insertUser(UserForm newUser);

}
