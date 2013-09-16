package com.kacofidoo.srm.orm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kacofidoo.srm.common.exception.SrmDaoException;
import com.kacofidoo.srm.orm.entity.User;

public interface UserDao {

	@Select("select count(*) from srm_user")
	int countAll() throws SrmDaoException;

	@Select("select * from srm_user where id=#{userId}")
	User getUserById(@Param("userId") long userId) throws SrmDaoException;

	@Select("select * from srm_user where name=#{username}")
	User getUserByName(@Param("username") String username) throws SrmDaoException;

	@Insert("insert into user(gender,company_id,company_admin_flag,age,name,nickname,password,purchaser_flag,sale_flag,system_admin_flag) values(#{gener},#{companyId},#{companyAdminFlag},#{age},#{name},#{nickname},#{password},#{purchaserFlag},#{saleFlag},#{systemAdminFlag})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void insert(User user) throws SrmDaoException;

}
