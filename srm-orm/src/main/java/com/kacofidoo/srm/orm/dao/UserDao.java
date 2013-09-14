package com.kacofidoo.srm.orm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kacofidoo.srm.orm.entity.User;

public interface UserDao {
	@Select("select count(*) from srm_user")
	int countAll();
	
	@Select("select * from srm_user where id=#{userId}")
	User getUserById(@Param("userId") String userId);
	
}
