//package com.example.springboot.service.impl;
//
//import com.example.springboot.dao.User;
//import com.example.springboot.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//import com.example.springboot.mapper.*;
//
//import java.util.List;
//
///**
// * Created by chenpei on 2018-08-14.
// */
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public User getUserById(Integer id) {
//        return userMapper.getUserById(id);
//    }
//
//    @Override
//    public List<User> getUserList() {
//        return userMapper.getUserList();
//    }
//
//    @Override
//    public int add(User user) {
//        return userMapper.add(user);
//    }
//
//    @Override
//    public int update(Integer id, User user) {
//        return userMapper.update(id, user);
//    }
//
//    @Override
//    public int delete(Integer id) {
//        return userMapper.delete(id);
//    }
//}
