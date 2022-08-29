package com.bridgelabz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findById(int id);

	User getById(int id);
}
