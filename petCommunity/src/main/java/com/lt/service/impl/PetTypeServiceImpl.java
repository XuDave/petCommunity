package com.lt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.IPetTypeDao;
import com.lt.pojo.PetType;
import com.lt.service.IPetTypeService;

@Service
public class PetTypeServiceImpl implements IPetTypeService {

	@Autowired
	private IPetTypeDao petTypeDao;
	
	@Override
	public List<PetType> selectAllPetTypes() {
		return petTypeDao.selectAllPetTypes();
	}

	@Override
	public PetType selectPetType(Integer tId) {
		return petTypeDao.selectByPrimaryKey(tId);
	}

	@Override
	public int insertPetType(PetType petType) {
		int i = petTypeDao.insert(petType);
		return i;
	}

	@Override
	public int updatePetType(PetType petType) {
		int i = petTypeDao.updateByPrimaryKeySelective(petType);
		return i;
	}

	@Override
	public int deletePetType(Integer tId) {
	    int i = petTypeDao.deleteByPrimaryKey(tId);
		return i;
	}

}
