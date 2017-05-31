package com.lt.dao;

import java.util.List;

import com.lt.pojo.User;

public interface IUserDao {
	
	List<User> selectAllUsers();
	
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}