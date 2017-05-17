package com.lt.service;

import java.util.List;

import com.lt.pojo.User;

public interface IUserService {
   
	/**
	 * 查询全部的用户
	 * 
	 * @return
	 */
	 List<User> selectAllUsers();
	 
	 /**
	  * 根据用户ID查询用户
	  * 
	  * @param uid
	  * @return
	  */
	 User selectUserById(Integer uid);
	 
     /**
      * 添加用户
      * 
      * @param user
      * @return
      */
	 int insertUser(User user);
	 
	 /**
	  * 更新用户
	  * 
	  * @param user
	  * @return
	  */
	 int updateUser(User user);
	 
	 /**
	  * 删除用户
	  * 
	  * @param uid
	  * @return
	  */
	 int deleteUser(Integer uid);
}
