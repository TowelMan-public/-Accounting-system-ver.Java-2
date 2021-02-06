package com.example.demo.select.espensesItem;

import java.util.List;

public interface DatabaseMapper {
	//普通に羅列の検索
	List<ResultForm> selectList(SelectForm form);
}
