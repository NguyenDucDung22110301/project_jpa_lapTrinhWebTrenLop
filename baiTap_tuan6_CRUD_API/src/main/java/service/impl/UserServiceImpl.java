package service.impl;

import DAO.impl.userDaoImpl;
import model.User;
import service.UserService;


public class UserServiceImpl implements UserService {
	userDaoImpl userDao = new userDaoImpl();
	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public User get(String username) {
		return userDao.get(username);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
			}
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		userDao.insert(new User(email, username, fullname,password, null, 5,phone,date));
			return true;
	}
	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void changePassword(String username, String password) {
		userDao.updatePassword(username, password);
	}

	@Override
	public boolean compUser(String s1, String s2) {
		if(s1.equals(s2)) {
			return true;
		}
		return false;
	}

	@Override
	public void changeName(String username, String name) {
		userDao.updateName(username, name);
	}

	@Override
	public void changePhone(String username, String phone) {
		userDao.updatePhone(username, phone);
	}

	
	
}