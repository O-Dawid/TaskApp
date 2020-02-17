package com.taskapp.taskapp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.taskapp.entities.Task;
import com.taskapp.entities.User;
import com.taskapp.services.TaskService;
import com.taskapp.services.UserService;

@SpringBootTest
class TaskappApplicationTests {

	@Autowired
	UserService userService;
	@Autowired
	TaskService taskService;
	
	@Test
	public void initDb() {
		
		userService.createUser(new User("test@gmail.com", "testUser", "1234@"));
		userService.createAdmin(new User("Admin@gmail.com", "test", "1234Admin@"));

		userService.createUser(new User("tes1t@gmail.com", "test1User", "1234@"));


		Task userTask = new Task("01/01/2019","00:01", "11:11", "Check your email");
		User user = userService.findOne("test@gmail.com");
		taskService.addTask(userTask, user);
		Task userTask1 = new Task("01/01/2019","00:01", "11:11", "ELKO");
		User user1 = userService.findOne("test@gmail.com");
		taskService.addTask(userTask1, user1);
		Task userTask2 = new Task("01/01/2019","00:01", "11:11", "Check your schedule");
		User user2 = userService.findOne("test@gmail.com");
		taskService.addTask(userTask2, user2);
		
	}
	
//	@Test
//	public void testUser() {
//
//		User user = userService.findOne("test@gmail.com");
//		assertNotNull(user);
//		User admin = userService.findOne("testAdmin@gmail.com");
//		assertEquals(admin.getEmail(), "testAdmin@gmail.com");
//	}
//	
//	
//	@Test
//	public void testTask() {
//		User user = userService.findOne("test@gmail.com");
//		List<Task> task = taskService.findUserTask(user);
//		assertNotNull(task);
//	}
	

}
