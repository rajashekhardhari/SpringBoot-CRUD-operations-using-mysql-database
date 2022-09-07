package com.bridgelabz.service;

import java.util.Optional;
import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.UserDTO;
import com.bridgelabz.exception.ExceptionResponse;
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
	public Response addUser(UserDTO userDTO) throws ExceptionResponse {
		User user = modelMapper.map(userDTO, User.class);
		String find = userDTO.getEmail();
		if (find.matches(user.getEmail())) {
			throw new ExceptionResponse(
					String.format(" User Email ID has been already entered in the Database"));
		}
		User addU = userRepo.save(user);
		Response response = new Response("The response message : User Information Sucessfully added to the DataBase",
				200, addU);
		return response;
	}

	@Override
	public Response deleteUser(int id) throws ExceptionResponse {
		Optional<User> find = userRepo.findById(id);
		if (!find.isPresent()) {
			throw new ExceptionResponse(String.format(
					"User Details not found with id " + id + ". Kindly check the entered Information for Deleting"));
		}
		userRepo.deleteById(id);
		Response response = new Response(
				"The response message : User Information Sucessfully deleted from the DataBase", 200, id);
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
		List<UserDTO> UserDTO = modelMapper.map(user, userType);
		return UserDTO;
	}

	@Override
	public Response getById(int id) throws ExceptionResponse {
		Optional<User> find = userRepo.findById(id);
		if (!find.isPresent()) {
			throw new ExceptionResponse(
					String.format("User not found with id " + id + ". Kindly check the entered Information"));
		}
		UserDTO dto = modelMapper.map(find, UserDTO.class);
		Response response = new Response(
				"The response message : User Information Sucessfully retrieved from the DataBase", 200, dto);

		return response;
	}

}
