package com.bridgelabz.service;

import java.util.Optional;
import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.UserDTO;
import com.bridgelabz.models.User;
import com.bridgelabz.repository.UserRepo;
import com.bridgelabz.utility.Response;



@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Response addUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User addU = userRepo.save(user);
		Response response = new Response("The response message : User Information Sucessfully added to the DataBase",
				200, addU);
		return response;
	}

	@Override
	public Response deleteUser(int id) {
		userRepo.deleteById(id);
		Response response = new Response(
				"The response message : User Information Sucessfully deleted from the DataBase", 200, null);
		return response;
	}

	@Override
	public Response updateUser(int id, UserDTO userDTO) {

		User user = modelMapper.map(userDTO, User.class);
		user.setId(id);
		User updateU = userRepo.save(user);

		Response response = new Response("The response message : User Information Sucessfully updated to the DataBase",
				200, updateU);
		return response;
	}

	@Override
	public List<UserDTO> findAll() {
		List<User> user = userRepo.findAll();
		Type userType = new TypeToken<List<UserDTO>>() {
			
		}.getType();
		List<UserDTO>UserDTO = modelMapper.map(user, userType);
		return UserDTO;
	}

	@Override
	public Response getingById(int id) {
		Optional<User> user = userRepo.findById(id);
		UserDTO userDTO12 = modelMapper.map(user, UserDTO.class);
		Response response = new Response("This is data", 200, userDTO12);
		return response;

	}

}
