/**
 * 
 */
package com.kacofidoo.srm.orm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kacofidoo.srm.orm.entity.Company;

/**
 * @author Jeff.Tsai
 * 
 */
public interface CompanyDao {

	@Select("select * from srm_company where id=#{id}")
	Company load(@Param("id") long id);

	@Update("delete from srm_company where id=#{id}")
	void delete(@Param("id") long id);

	@Insert("insert into srm_company() values()")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void insert(Company company);

	@Update("update srm_company set address=#{address},description=#{description},name=#{name},website=#{website},zipcode=#{zipcode},create_time=#{createTime},modify_time=#{modifyTime},status=#{status} where id=#{id}")
	void update(Company company);

}
