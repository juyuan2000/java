package com.djs.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.djs.dao.IPetDao;
import com.djs.entity.Category;
import com.djs.entity.Pet;
import com.djs.mapper.IPetMapper;
import com.djs.util.MybatisUtil;

public class PetDaoImpl implements IPetDao {
	private MybatisUtil db = MybatisUtil.getInstance();

	@Override
	public void saveCategory(Category category) {
		SqlSession sqlSession = db.getSqlSession();

		IPetMapper mapper = sqlSession.getMapper(IPetMapper.class);
		mapper.saveCategory(category);

		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public void deleteCategory(int id) {

	}

	@Override
	public void updateCategory(Category category) {

	}

	@Override
	public List<Category> findAllCategory() {
		SqlSession sqlSession = db.getSqlSession();
		IPetMapper mapper = sqlSession.getMapper(IPetMapper.class);
		List<Category> list = mapper.findAllCategory();
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public void savePet(Pet pet) {
		SqlSession sqlSession = db.getSqlSession();
		IPetMapper mapper = sqlSession.getMapper(IPetMapper.class);
		mapper.savePet(pet);

		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public void deletePet(int id) {

	}

	@Override
	public void updatePet(Pet pet) {

	}

	@Override
	public List<Pet> findAllPet() {
		SqlSession sqlSession = db.getSqlSession();
		IPetMapper mapper = sqlSession.getMapper(IPetMapper.class);
		List<Pet> list = mapper.findAllPet();
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public List<Pet> findLikePetName(String name) {

		return null;
	}

}
