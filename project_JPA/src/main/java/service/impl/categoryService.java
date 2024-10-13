package service.impl;

import java.util.List;

import DAO.ICategoryDao;
import DAO.impl.categoryDAO;
import entity.Category;
import service.ICategoryService;

public class categoryService implements ICategoryService {
	public ICategoryDao cateDao = new categoryDAO();
	
	@Override
	public int count() {
		return cateDao.count();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		 return cateDao.findAll(page, pagesize);
	}

	@Override
	public List<Category> searchByName(String catname) {
		 return cateDao.searchByName( catname);
	}

	@Override
	public List<Category> findAll() {
		 return cateDao.findAll();
	}

	@Override
	public Category findByCategoryname(String name) throws Exception {
		try {
			return cateDao.findByCategoryname(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category findById(int cateid) {
		 return cateDao.findById(cateid);
	}

	@Override
	public void delete(int cateid) throws Exception {
		try {
			cateDao.delete(cateid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category category) {
		Category cate = this.findById(category.getCategoryId());
		if (cate != null) {
			cateDao.update(category);
		}
	}

	@Override
	public void insert(Category category) {
		cateDao.insert(category);
	}
	
}
