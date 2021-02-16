package com.example.demo.makeNewUser;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MakeNewUserDatabaseMapper {
	//ユーザーを登録する
	void insertUser(UserForm newUser);

}
