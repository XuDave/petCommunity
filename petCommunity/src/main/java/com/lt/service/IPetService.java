package com.lt.service;

import java.util.List;

import com.lt.pojo.Pet;

public interface IPetService {
    /**
     * 查询全部的宠物
     * 
     * @return
     */
	List<Pet> selectAllPets();
	
	/**
	 * 根据主键查询宠物
	 * 
	 * @param petId
	 * @return
	 */
	Pet selectPetById(String petId);
	
	/**
	 * 根据用户编号查询宠物信息
	 * 
	 * @param uId
	 * @return
	 */
	List<Pet> selectPetByUserId(String uId);
	
	/**
	 * 添加宠物信息
	 * 
	 * @param pet
	 * @return
	 */
	int insertPet(Pet pet);
	
	/**
	 * 更新宠物信息
	 * 
	 * @return
	 */
	int updatePet(Pet pet);
	
	/**
	 * 根据主键删除宠物信息
	 * 
	 * @param petId
	 * @return
	 */
	int deletePet(String petId);
	
	/**
	 * 根据用户编号删除宠物信息
	 * 
	 * @param uId
	 * @return
	 */
	int deletePetByUserId(String uId);
	
    
}
