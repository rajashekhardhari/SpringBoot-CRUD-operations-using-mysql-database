package com.bridgelabz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.models.User;
import com.bridgelabz.utility.Response;

@Service
public interface IUserService {

	String addUser(User user);

	String deleteUser(Integer id);

	String updateUser(int id, User user);
	
	List<User> findAll();
	
	User getUser(int Id);
	
	Response getingById(int id);

}
