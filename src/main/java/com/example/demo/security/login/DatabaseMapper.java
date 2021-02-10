package com.example.demo.security.login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DatabaseMapper {
	//ユーザー情報の取得（ユーザー情報含む）
	Form selectById(@Param("userId") Integer userId);
}