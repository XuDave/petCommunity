package com.lt.dao;

import java.util.List;

import com.lt.pojo.Pet;

public interface IPetDao {
	
	List<Pet> selectAllPets();
	
	List<Pet> selectPetsByUser(Integer userId);
	
	List<Pet> selectPetsByType(Integer typeId);
	
    int deleteByPrimaryKey(Integer petid);
    
    int deleteByUserId(Integer userId);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectByPrimaryKey(Integer petid);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);
}