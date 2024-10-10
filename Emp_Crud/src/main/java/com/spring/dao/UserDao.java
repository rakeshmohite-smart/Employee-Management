package com.spring.dao;

import com.spring.entity.User;

public interface UserDao {
	
	public long saveUser(User user);
	
	public User loginUser(String email, String password);

}
