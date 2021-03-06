package repository.select;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dto.select.expensesItemDto;
import entity.select.ExpensesItemResultEntity;

@Mapper
public interface SelectExpensesItemDatabaseMapper {
	//普通に羅列の検索
	List<ExpensesItemResultEntity> selectList(expensesItemDto form);
}
