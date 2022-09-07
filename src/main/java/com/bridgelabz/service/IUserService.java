package com.bridgelabz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.dto.UserDTO;
import com.bridgelabz.exception.ExceptionResponse;
import com.bridgelabz.models.User;
import com.bridgelabz.utility.Response;

@Service
public interface IUserService {

	Response addUser(UserDTO userDTO)throws ExceptionResponse;

	Response deleteUser(int id)throws ExceptionResponse;

	Response updateUser(int id, UserDTO userDTO);

	List<UserDTO> findAll();

	Response getById(int id)throws ExceptionResponse;

}
