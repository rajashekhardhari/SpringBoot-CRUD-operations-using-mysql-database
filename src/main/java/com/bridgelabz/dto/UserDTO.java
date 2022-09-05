package com.bridgelabz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserDTO {
	@NotNull(message = "name should not be null")
	private String name;
	@Email(message = "invalid email")
	private String email;
	@Pattern(regexp = "^\\d{10}$", message = "invalid number")
	private String number;

}
