package com.example.springboot.mapper;

import com.example.springboot.dao.UserDao;
import com.example.springboot.param.UserParam;
import java.util.List;



public interface UserMapper {

	List<UserDao> getAll();

	List<UserDao> getList(UserParam userParam);

	int getCount(UserParam userParam);

	UserDao getOne(Long id);

	void insert(UserDao user);

	int update(UserDao user);

	int delete(Long id);

}