package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IcategoryDAO;
import config.JDBCUtil;
import model.categoryModel;

public class categoryDAOImpl implements IcategoryDAO {
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<categoryModel> findALL() {
	    String sql = "SELECT * FROM category";
	    List<categoryModel> list = new ArrayList<>();
	    try {
	        conn = JDBCUtil.getConnection();
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            categoryModel category = new categoryModel();
	            category.setCategoryId(rs.getInt("categoryId"));  
	            category.setCategoryName(rs.getString("categoryName"));  
	            category.setImages(rs.getString("images")); 
	            category.setStatus(rs.getInt("status"));  
	            list.add(category);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	@Override
	public categoryModel findById(int id) {
	    String sql = "SELECT * FROM category WHERE categoryId = ?";
	    categoryModel category = null;
	    try {
	        conn = JDBCUtil.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            category = new categoryModel();
	            category.setCategoryId(rs.getInt("categoryId"));
	            category.setCategoryName(rs.getString("categoryName"));
	            category.setImages(rs.getString("images"));
	            category.setStatus(rs.getInt("status"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return category;
	}

	@Override
	public void insert(categoryModel category) {
	    String sql = "INSERT INTO category (categoryName, images, status) VALUES (?, ?, ?)";
	    try {
	        conn = JDBCUtil.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, category.getCategoryName());
	        ps.setString(2, category.getImages());
	        ps.setInt(3, category.getStatus());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public void update(categoryModel category) {
	    String sql = "UPDATE category SET categoryName = ?, images = ?, status = ? WHERE categoryId = ?";
	    try {
	        conn = JDBCUtil.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, category.getCategoryName());
	        ps.setString(2, category.getImages());
	        ps.setInt(3, category.getStatus());
	        ps.setInt(4, category.getCategoryId());  // Cập nhật theo trường `category`
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void delete(int id) {
	    String sql = "DELETE FROM category WHERE categoryId = ?";
	    try {
	        conn = JDBCUtil.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public List<categoryModel> findName(String keyWord) {
	    String sql = "SELECT * FROM category WHERE categoryName LIKE ?";
	    List<categoryModel> list = new ArrayList<>();
	    try {
	        conn = JDBCUtil.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, "%" + keyWord + "%");
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            categoryModel category = new categoryModel();
	            category.setCategoryId(rs.getInt("categoryId"));
	            category.setCategoryName(rs.getString("categoryName"));
	            category.setImages(rs.getString("images"));
	            category.setStatus(rs.getInt("status"));
	            list.add(category);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
}
