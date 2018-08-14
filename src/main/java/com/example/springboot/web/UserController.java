package com.example.springboot.web;


import com.example.springboot.dao.UserDao;
import com.example.springboot.enums.UserSexEnum;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.param.UserParam;
import com.example.springboot.result.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getUsers")
	public List<UserDao> getUsers() {
		List<UserDao> users=userMapper.getAll();
		return users;
	}

    @RequestMapping("/getList")
    public Page<UserDao> getList(UserParam userParam) {
        List<UserDao> users=userMapper.getList(userParam);
        long count=userMapper.getCount(userParam);
        Page page = new Page(userParam,count,users);
        return page;
    }

    @RequestMapping("/getUser")
    public UserDao getUser(Long id) {
    	UserDao user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(@RequestParam(value = "name")String name,@RequestParam(value = "sex")String sex,@RequestParam(value = "password")String password) {
        UserDao user = new UserDao();
        user.setUserName(name);
        user.setPassWord(password);
        if(sex.equals("man")||sex.equals("MAN")){
            user.setUserSex(UserSexEnum.MAN);
        }else {
            user.setUserSex(UserSexEnum.WOMAN);
        }
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserDao user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    
}