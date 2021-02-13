package com.example.demo.makeNewUser;

import org.apache.ibatis.annotations.Mapper;

@Mapper//TODO 実装 変えるかもしれない
public interface DatabaseMapper {
	//ユーザーを登録する
	void insertUser(UserForm newUser);

}
