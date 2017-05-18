package com.lt.service;

import java.util.List;

import com.lt.pojo.Admin;

public interface IAdminService {
   /**
    * 查询全部的管理员
    * 
    * @return
    */
   List<Admin> selectAllAdmins();
   
   /**
    * 根据主键查询管理员
    * 
    * @param aId
    * @return
    */
   Admin selectAdmin(Integer aId);
   
   /**
    * 添加管理员
    * 
    * @param admin
    * @return
    */
   int insertAdmin(Admin admin);
   
   /**
    * 更新管理员
    * 
    * @param admin
    * @return
    */
   int updateAdmin(Admin admin);
   
   /**
    * 根据主键删除管理员
    * 
    * @param aId
    * @return
    */
   int deleteAdmin(Integer aId);
   
}
