package service;

import model.User;

public interface UserService {
	User login (String username, String password);
	User get(String username);
	void insert(User user);
	boolean register(String email, String password, String username, String
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	void changePassword(String username, String password);
	boolean compUser(String s1, String s2);
	void changeName(String username, String name);
	void changePhone(String username, String phone);
}