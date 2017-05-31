package com.lt.service;

import java.util.List;

import com.lt.pojo.PetType;

public interface IPetTypeService {
	/**
	 * 查询全部的宠物种类
	 * 
	 * @return
	 */
    List<PetType> selectAllPetTypes();
    
    /**
     * 根据主键查询宠物种类
     * 
     * @param tId
     * @return
     */
    PetType selectPetType(String tId);
    
    /**
     * 添加宠物种类
     * 
     * @param petType
     * @return
     */
    int insertPetType(PetType petType);
    
    /**
     * 更新宠物种类
     * 
     * @param petType
     * @return
     */
    int updatePetType(PetType petType);
    
    /**
     * 根据主键删除宠物种类
     * 
     * @param tId
     * @return
     */
    int deletePetType(String tId);
}
