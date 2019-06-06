package com.djs.service.impl;

import java.util.List;

import com.djs.dao.IPetDao;
import com.djs.dao.impl.PetDaoImpl;
import com.djs.entity.Category;
import com.djs.entity.Pet;
import com.djs.service.IPetService;

public class PetServiceImpl implements IPetService {
	private IPetDao dao;
	
	public PetServiceImpl() {
		dao = new PetDaoImpl();
	}

	@Override
	public void addCategory(Category category) {
		dao.saveCategory(category);

	}

	@Override
	public List<Category> findAllCategory() {
	
		return dao.findAllCategory();
	}

	@Override
	public void addPet(Pet pet) {
	
		dao.savePet(pet);
	}

	@Override
	public List<Pet> findAllPet() {
	
		return dao.findAllPet();
	}

}
