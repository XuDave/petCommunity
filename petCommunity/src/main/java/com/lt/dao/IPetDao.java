package com.lt.dao;

import java.util.List;

import com.lt.pojo.Pet;

public interface IPetDao {
	
	List<Pet> selectAllPets();
	
	List<Pet> selectPetsByUser(String userId);
	
	List<Pet> selectPetsByType(String typeId);
	
    int deleteByPrimaryKey(String petid);
    
    int deleteByUserId(String userId);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectByPrimaryKey(String petid);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);
}