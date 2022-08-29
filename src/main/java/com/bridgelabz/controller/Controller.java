package com.bridgelabz.controller;

import java.util.List;

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
import com.bridgelabz.models.User;
import com.bridgelabz.service.IUserService;
import com.bridgelabz.utility.Response;

@RestController
@RequestMapping("/home")
public class Controller {

	@Autowired
	private IUserService userService;

	@PostMapping("/post")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		String response = userService.addUser(user);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		String response = userService.deleteUser(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user) {
		String response = userService.updateUser(id, user);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("/get")
	public List<User> getList() {
		return userService.findAll();
	}

	@GetMapping("{id1}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		ResponseEntity<User> response = new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
		return response;
	}

	@GetMapping("/accept")
	public ResponseEntity<Response> getUserById1(@RequestParam int id) {
		ResponseEntity<Response> response = new ResponseEntity<Response>(userService.getingById(id), HttpStatus.OK);
		return response;
	}
}