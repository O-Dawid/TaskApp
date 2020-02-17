package com.taskapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskapp.entities.Task;
import com.taskapp.entities.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

	List<Task> findByDescriptionContaining(String description);

	List<Task> findByDescriptionContainingAndUser(String description, User user);

}
