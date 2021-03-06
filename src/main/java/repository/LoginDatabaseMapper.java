package repository;

import org.apache.ibatis.annotations.Mapper;

import form.LoginForm;

@Mapper
public interface LoginDatabaseMapper {
	//ユーザー情報の取得（ユーザー情報含む）
	LoginForm selectById(Integer userId);
}