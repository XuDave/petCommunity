package com.lt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.IAdminDao;
import com.lt.pojo.Admin;
import com.lt.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
	private IAdminDao adminDao;
	
	@Override
	public List<Admin> selectAllAdmins() {
		return adminDao.selectAllAdmins();
	}

	@Override
	public Admin selectAdmin(Integer aId) {
		return adminDao.selectByPrimaryKey(aId);
	}

	@Override
	public int insertAdmin(Admin admin) {
		int i = adminDao.insert(admin);
		return i;
	}

	@Override
	public int updateAdmin(Admin admin) {
		int i = adminDao.updateByPrimaryKeySelective(admin);
		return i;
	}

	@Override
	public int deleteAdmin(Integer aId) {
		int i = adminDao.deleteByPrimaryKey(aId);
		return i;
	}

	@Override
	public Admin selectByName(String adminName) {
		return adminDao.selectByName(adminName);
	}

}
