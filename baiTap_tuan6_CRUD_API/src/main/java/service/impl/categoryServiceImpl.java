package service.impl;

import java.util.List;

import DAO.IcategoryDAO;
import DAO.impl.categoryDAOImpl;
import model.categoryModel;
import service.IcategoryService;

public class categoryServiceImpl implements IcategoryService{
	IcategoryDAO cate = new categoryDAOImpl();
	
	@Override
	public List<categoryModel> findALL() {
		return cate.findALL();
	}

	@Override
	public categoryModel findById(int id) {
		return cate.findById(id);
	}

	@Override
	public void insert(categoryModel category) {
		cate.insert(category);
		
	}

	@Override
	public void update(categoryModel category) {
		categoryModel categ = new categoryModel();
		categ = cate.findById(category.getCategoryId());
		if(categ != null) {
			cate.update(category);
		}
	}

	@Override
	public void delete(int id) {
		categoryModel categ = new categoryModel();
		categ = cate.findById(id);
		if(categ != null) {
			cate.delete(id);
		}
	}

	@Override
	public List<categoryModel> findName(String keyWord) {
		return cate.findName(keyWord);
	}
	
}
