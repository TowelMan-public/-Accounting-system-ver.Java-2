package repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import entity.CandidateEntity;

@Mapper
public interface CandidateDatabaseMapper {
	//経費の項目の候補を取得する
	List<CandidateEntity> getCandidateExpensesItem(Integer companyAccountid);
	
	//会社の候補を取得する
	List<CandidateEntity> getCandidateCompany(Integer companyAccountid);
}
