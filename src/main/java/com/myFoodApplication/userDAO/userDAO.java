package com.myFoodApplication.userDAO;

import java.util.List;

import com.myFoodApplication.user.User;

public interface userDAO {
	
	void insert(User u);
	List<User> fetchAll();
	User fetchSpecific(String email);
	int update(User u);
	int delete(int i);

}
