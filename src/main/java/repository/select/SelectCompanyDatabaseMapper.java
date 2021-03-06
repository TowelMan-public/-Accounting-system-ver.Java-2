package repository.select;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelectCompanyDatabaseMapper {
	//普通に羅列の検索
	List<BaseEarningsResultEntity> selectList(BaseEarningstDto form);
}
