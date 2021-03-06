package repository.select.base.earnings;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dto.select.BaseEarningstDto;
import entity.select.BaseEarningsResultEntity;
import entity.select.GroupResultEntity;

@Mapper
public interface SelectConsumptionTaxDatabaseMapper extends BaseDatabaseMapper {
	//グループ検索
	@Override
	List<GroupResultEntity> selectGroup(BaseEarningstDto form);
	
	//普通に羅列の検索
	@Override
	List<BaseEarningsResultEntity> selectList(BaseEarningstDto form);
}
