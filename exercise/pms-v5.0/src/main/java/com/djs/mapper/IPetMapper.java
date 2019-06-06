package com.djs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.djs.entity.Category;
import com.djs.entity.Pet;

public interface IPetMapper {
	
	void saveCategory(Category category);
	void deleteCategory(int id);
	void updateCategory(Category category);
	List<Category> findAllCategory();
	
	
	void savePet(Pet pet);
	void deletePet(int id);
	void updatePet(Pet pet);
	List<Pet> findAllPet();
	List<Pet> findLikePetName(@Param("name") String name);
	
	

}
