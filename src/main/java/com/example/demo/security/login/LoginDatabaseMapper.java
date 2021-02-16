package com.example.demo.security.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDatabaseMapper {
	//ユーザー情報の取得（ユーザー情報含む）
	Form selectById(Integer userId);
}