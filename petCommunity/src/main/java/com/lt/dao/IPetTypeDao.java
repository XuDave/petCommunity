package com.lt.dao;

import java.util.List;

import com.lt.pojo.PetType;

public interface IPetTypeDao {
	
	List<PetType> selectAllPetTypes();
	
    int deleteByPrimaryKey(String pettypeid);

    int insert(PetType record);

    int insertSelective(PetType record);

    PetType selectByPrimaryKey(String pettypeid);

    int updateByPrimaryKeySelective(PetType record);

    int updateByPrimaryKey(PetType record);
}