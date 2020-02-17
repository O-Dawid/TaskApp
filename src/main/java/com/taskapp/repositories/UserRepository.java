package com.taskapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	List<User> findByNameLike(String name);

	List<User> findByNameStartingWith(String name);


}
