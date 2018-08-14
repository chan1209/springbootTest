//package com.example.springboot.mapper;
//
//
//import com.example.springboot.dao.UserDao;
//import com.example.springboot.enums.UserSexEnum;
//import com.example.springboot.param.UserParam;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//public interface UserMapper {
//
//	@Select("SELECT * FROM users")
//	@Results({
//		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
//		@Result(property = "nickName", column = "nick_name")
//	})
//	List<UserDao> getAll();
//
//	@SelectProvider(type = UserSql.class, method = "getList")
//	List<UserDao> getList(UserParam userParam);
//
//	@SelectProvider(type = UserSql.class, method = "getCount")
//	int getCount(UserParam userParam);
//
//	@Select("SELECT * FROM users WHERE id = #{id}")
//	@Results({
//		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
//		@Result(property = "nickName", column = "nick_name")
//	})
//	UserDao getOne(Long id);
//
//	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
//	void insert(UserDao user);
//
//	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
//	void update(UserDao user);
//
//	@Delete("DELETE FROM users WHERE id =#{id}")
//	void delete(Long id);
//
//}