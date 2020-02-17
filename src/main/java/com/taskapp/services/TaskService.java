package com.taskapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskapp.entities.Task;
import com.taskapp.entities.User;
import com.taskapp.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task> findUserTask(User user){
		return taskRepository.findByUser(user);
	}

	public List<Task> findByDescription(String description) {
		// TODO Auto-generated method stub
		return taskRepository.findByDescriptionContaining(description);
	}

	public List<Task> findByDescriptionAndUser(String description, User user) {
		// TODO Auto-generated method stub
		return taskRepository.findByDescriptionContainingAndUser(description, user);
	}
}
