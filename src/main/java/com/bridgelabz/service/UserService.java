package com.bridgelabz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.models.User;
import com.bridgelabz.repository.UserRepo;
import com.bridgelabz.utility.Response;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public String addUser(User user) {
		userRepo.save(user);
		return "User Successfully added to db";
	}

	@Override
	public String deleteUser(Integer id) {
		userRepo.deleteById(id);
		return "User Successfully deleteted from db";
	}

	@Override
	public String updateUser(int id, User user) {
		User user1 = userRepo.findById(id);

		if (user1 != null) {
			user1.setName(user.getName());

			if (user.getEmail() != null) {
				user1.setEmail(user.getEmail());
			}
			if (user.getNumber() != null) {
				user1.setNumber(user.getNumber());
			}
		}
		userRepo.save(user1);
		return "User Successfully Updated to db";
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(int id) {
		User user = userRepo.findById(id);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}


	@Override
	public Response getingById(int id) {
		User user = userRepo.findById(id);
		Response response=new Response("This is data",200,user);
		return response;
		

	}

}
