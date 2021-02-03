package com.example.demo.security.login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DatabaseMapper {
	Form selectById(@Param("username") String username);
}