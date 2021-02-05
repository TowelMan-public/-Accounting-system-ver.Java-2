package com.example.demo.configuration;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper//TODO 実装 変えるかもしれない
public interface DatabaseMapper {
	//その会社に設定されている消費税率を取得する
	Double getConsumptionTax(@Param("companyId") Integer companyId);

	//その会社に登録されているユーザーリストを取得する
	List<CompanyUserForm> selectUsersByCompanyId(@Param("companyId") Integer companyId);

	//指定されたユーザーIDが有効かどうかを調べる
	boolean isEnabledUser(@Param("userId") Integer userId);

	//ユーザーの情報を更新する
	void updateUser(CompanyUserForm form);

	//ユーザーを削除する
	void deleteUser(IdForm form);

	//その会社に設定されている消費税率を変更する
	void updateConsumptionTaxRate(ConfigurationTaxRateForm form);

	//会社名を変更する
	void updateCompanyName(CompanyConfigurationForm form);

	//その会社の中のマスター権限者数の取得
	int getMasterAuthorityCountInCompany(@Param("companyId") Integer companyId);

	//指定されたユーザーの権限を取得する
	String getAuthorityByUserId(@Param("userId") Integer userId);
}
