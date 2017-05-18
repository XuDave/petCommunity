package com.lt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.IPetDao;
import com.lt.pojo.Pet;
import com.lt.service.IPetService;

@Service
public class PetSeviceImpl implements IPetService {
   
	@Autowired
	private IPetDao petDao;
	
	@Override
	public List<Pet> selectAllPets() {
		return petDao.selectAllPets();
	}

	@Override
	public Pet selectPetById(Integer petId) {
		return petDao.selectByPrimaryKey(petId);
	}

	@Override
	public List<Pet> selectPetByUserId(Integer uId) {
		return petDao.selectPetsByUser(uId);
	}

	@Override
	public int insertPet(Pet pet) {
		return petDao.insert(pet);
	}

	@Override
	public int updatePet(Pet pet) {
		return petDao.updateByPrimaryKeySelective(pet);
	}

	@Override
	public int deletePet(Integer petId) {
		return petDao.deleteByPrimaryKey(petId);
	}

	@Override
	public int deletePetByUserId(Integer uId) {
		return petDao.deleteByUserId(uId);
	}

}
