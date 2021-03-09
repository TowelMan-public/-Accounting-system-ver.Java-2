package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDto;

@Mapper
public interface MakeNewUserMapper {
	//ユーザーを登録する
	void insertUser(UserDto newUser);

}
