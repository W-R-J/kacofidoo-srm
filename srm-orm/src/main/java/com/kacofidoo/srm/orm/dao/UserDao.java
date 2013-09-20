package com.kacofidoo.srm.orm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kacofidoo.srm.orm.entity.User;

public interface UserDao {

	@Select("select count(*) from srm_user")
	int countAll();

	@Select("select * from srm_user where id=#{userId}")
	User getUserById(@Param("userId") long userId);

	@Select("select * from srm_user where name=#{username}")
	User getUserByName(@Param("username") String username);

	@Insert("insert into srm_user(gender,company_id,company_admin_flag,birthday,name,nickname,password,system_admin_flag,create_time,creator,modifier,modify_time,status)"
			+ " values(#{gender},#{companyId},#{companyAdminFlag},#{birthday},#{name},#{nickname},#{password},#{systemAdminFlag},#{createTime},#{creator},#{modifier},#{modify_time},#{status})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void insert(User user);

	@Update("update srm_user set gener=#{gender},company_id=#{companyId},company_admin_flag=#{companyAdminFlag},birthday=#{birthday},name=#{name},nickname=#{nickname},password=#{password},system_admin_flag=#{systemAdminFlag},create_time=#{createTime},modify_time=#{modifyTime},status=#{status} where id=#{id}")
	void update(User user);

	@Select("select * from srm_user where 1=1 ")
	List<User> queryWithPage(int pageNo, int pageSize,String username,Long companyId,Integer status);

	@Delete("delete from srm_user where id=#{id}")
	void delete(long id);
	

}
