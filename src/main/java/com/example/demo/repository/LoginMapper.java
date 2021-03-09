package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.form.LoginForm;

@Mapper
public interface LoginMapper {
	//ユーザー情報の取得（ユーザー情報含む）
	LoginForm selectById(Integer userId);
}