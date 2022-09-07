package com.bridgelabz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.UserDTO;
import com.bridgelabz.exception.ExceptionResponse;
import com.bridgelabz.service.IUserService;
import com.bridgelabz.utility.Response;

@RestController
@RequestMapping("/home")
public class Controller {

	@Autowired
	private IUserService userService;

	@PostMapping("/post")
	public ResponseEntity<Response> addUser(@RequestBody @Valid UserDTO userDTO) throws ExceptionResponse{
		ResponseEntity<Response> response = new ResponseEntity<Response>(userService.addUser(userDTO), HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable Integer id)throws ExceptionResponse {
		ResponseEntity<Response> response = new ResponseEntity<Response>(userService.deleteUser(id), HttpStatus.OK);
		return response;
	}

	@PutMapping("/put/{id}")
	public ResponseEntity<Response> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
		ResponseEntity<Response> response = new ResponseEntity<Response>(userService.updateUser(id, userDTO),
				HttpStatus.OK);
		return response;
	}

	
	@GetMapping("/get")
	public List<UserDTO> getList()throws ExceptionResponse {
		return userService.findAll();
	}

	@GetMapping("/getdatabyid")
	public ResponseEntity<Response> getUserById1(@RequestParam int id) throws ExceptionResponse{
		ResponseEntity<Response> response = new ResponseEntity<Response>(userService.getById(id), HttpStatus.OK);
		return response;
	}
	

}