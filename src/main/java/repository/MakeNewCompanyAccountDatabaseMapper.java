package repository;

import org.apache.ibatis.annotations.Mapper;

import dto.UserDto;
import entity.CompanyAccountEntity;

@Mapper
public interface MakeNewCompanyAccountDatabaseMapper {
	//新しい会社IDを取得する
	void getNewCompanyAccountId(CompanyAccountEntity company);

	//会社を登録する
	void insertCompanyAccount(CompanyAccountEntity company);
	
	//ユーザーを登録する
	void insertUser(UserDto user);
	
}