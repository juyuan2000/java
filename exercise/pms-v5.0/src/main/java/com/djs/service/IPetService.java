package com.djs.service;

import java.util.List;

import com.djs.entity.Category;
import com.djs.entity.Pet;

public interface IPetService {
	
	void addCategory(Category category);
	
	List<Category> findAllCategory();
	
	void addPet(Pet pet);
	
	List<Pet> findAllPet();

}
