package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.form.configuration.CompanyConfigurationForm;
import com.example.demo.form.configuration.CompanyUserForm;
import com.example.demo.form.configuration.ConfigurationTaxRateForm;
import com.example.demo.form.configuration.DeleteForm;

@Mapper
public interface ConfigurationMapper {
	//その会社に設定されている消費税率を取得する
	Double getConsumptionTax(Integer companyId);

	//その会社に登録されているユーザーリストを取得する
	List<CompanyUserForm> selectUsersByCompanyId(Integer companyId);

	//指定されたユーザーIDが有効かどうかを調べる
	boolean isEnabledUser(@Param("userId") Integer userId,@Param("companyId")Integer companyId);

	//ユーザーの情報を更新する
	void updateUser(CompanyUserForm form);

	//ユーザーを削除する
	void deleteUser(DeleteForm form);

	//その会社に設定されている消費税率を変更する
	void updateConsumptionTaxRate(ConfigurationTaxRateForm form);

	//会社名を変更する
	void updateCompanyName(CompanyConfigurationForm form);

	//その会社の中のマスター権限者数の取得
	Integer getMasterAuthorityCountInCompany(Integer companyId);

	//指定されたユーザーの権限を取得する
	String getAuthorityByUserId(Integer userId);
}
