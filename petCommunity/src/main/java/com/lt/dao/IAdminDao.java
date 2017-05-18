package com.lt.dao;

import java.util.List;

import com.lt.pojo.Admin;

public interface IAdminDao {
	
	List<Admin> selectAllAdmins();
	
	Admin selectByName(String adminName);
	
    int deleteByPrimaryKey(Integer adminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}