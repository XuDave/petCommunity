package com.lt.petCommunity.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.dao.IPetDao;
import com.lt.pojo.Pet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class PetDaoTest {

	@Autowired
	private IPetDao petDao;
	
	@Test
	public void testFindPetByUser(){
		List<Pet> petList = petDao.selectPetsByUser(1);
		System.out.println("宠物个数:"+petList.size());
	}
}
