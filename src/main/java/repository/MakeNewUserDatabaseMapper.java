package repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.makeNewUser.UserForm;

@Mapper
public interface MakeNewUserDatabaseMapper {
	//ユーザーを登録する
	void insertUser(UserForm newUser);

}
