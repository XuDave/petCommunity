package com.lt.petCommunity.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.dao.IAdminDao;
import com.lt.pojo.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class AdminDaoTest {

	@Autowired
	private IAdminDao adminDao;	
	
	@Test
	public void testSelectAllAdmin(){
		List<Admin> adminList = adminDao.selectAllAdmins();
		System.out.println(adminList.size());
	}
	
	//@Test
	public void testInsertAdmin(){
		Admin admin = new Admin();
		admin.setAdminname("测试");
		admin.setPassword("123");
		adminDao.insert(admin);
		//System.out.println("新添加的ID:"+admin.getAdminid());
	}
}
