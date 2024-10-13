package DAO;

import java.util.List;

import model.categoryModel;

public interface IcategoryDAO {
	List<categoryModel> findALL();
	categoryModel findById(int id);
	void insert (categoryModel category);
	void update (categoryModel category);
	void delete(int id);
	List<categoryModel > findName(String keyWord);
}
