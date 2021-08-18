package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Task;
import model.TaskService;

class TaskServiceTest {
	
	/** Object **/
	
	TaskService taskService = TaskService.getInstance();
	
	/** JUnit Tests Pass **/
	
	@Test 
	void testTaskServiceCreationPass() {
		String taskDescription = "Botanist will harvest flora on grassy plots";
		
		Task taskDemo = new Task("001", "Harvest", taskDescription);
		assertTrue(taskService.addTask(taskDemo)); // Add the original task object into taskList.
		
		Task taskCopy = taskService.getTask("001"); // Copy task object in taskList.

		assertTrue(taskCopy.getId().contentEquals(taskDemo.getId())); // Verify id matches copy.
		assertTrue(taskCopy.getName().contentEquals(taskDemo.getName())); // Verify name matches copy.
		assertTrue(taskCopy.getDescription().contentEquals(taskDemo.getDescription())); // Verify description matches copy.
	} // Passed successfully

	@Test
	void testTaskServiceAddPass() {
		String taskDescription1 = "Botanist will harvest flora on grassy plots";
		String taskDescription2 = "Miners will excavate minerals on rocky plots";
		String taskDescription3 = "Fishermen will reel fish from the ocean";
		
		Task taskBot = new Task("002", "Harvest", taskDescription1);
		Task taskMin = new Task("101", "Mine", taskDescription2);
		Task taskFsh = new Task("201", "Fish", taskDescription3);
		
		assertTrue(taskService.addTask(taskBot));
		assertTrue(taskService.addTask(taskMin));
		assertTrue(taskService.addTask(taskFsh));
	} // Successfully passed
	
	@Test
	void testTaskServiceDeletePass() {
		String taskDescription = "Botanist will harvest flora on grassy plots";
		
		Task taskDemo = new Task("003", "Harvest", taskDescription);
		
		assertTrue(taskService.addTask(taskDemo)); // Validate if the objects was added
		assertTrue(taskService.deleteTask("003")); // Validate if the object was deleted
		assertTrue(taskService.getTask(taskDemo.getId()) == null); // Validate that the removed object is null.	
	} // Successfully passed
	
	@Test
	void testTaskServiceUpdatePass() {
		String taskDescription = "Miners will excavate minerals on rocky plots";
		String updateDescription = "Demolitionist will clear a path with bombs";
		String updateName = "Demolish";
		
		Task taskDemo = new Task("102", "Mine", taskDescription);
		
		// We add taskDemo to the list and then update it by passing in some pre-made arguments.
		assertTrue(taskService.addTask(taskDemo));
		assertTrue(taskService.updateTask(taskDemo, updateName, updateDescription));
		
		// We then check to see if these update values inside of taskList are the same.
		assertTrue(taskDemo.getName().equals("Demolish"));
		assertTrue(taskDemo.getDescription().equals(updateDescription));
	} // Successfully passed
	
	/** JUnit Tests Fail **/
	
	@Test
	void testTaskServiceCreationFail() {
		String taskDescription = "Botanist will harvest flora on grassy plots";
		
		Task taskDemo = new Task("005", "Harvest", taskDescription);
		Task taskCopy = new Task("005", "Harvest", taskDescription);
		
		assertTrue(taskService.addTask(taskDemo));
		assertFalse(taskService.addTask(taskCopy)); // Should fail due to task already existing
	} // Successfully failed
	
	@Test
	void testTaskServiceAddFail() {
		String taskDescription = "Botanist will harvest flora on grassy plots";
		
		Task taskDemo = new Task("004", "Harvest", taskDescription);
		Task taskCopy = new Task("004", "Harvest", taskDescription);
		assertTrue(taskService.addTask(taskDemo));
		assertFalse(taskService.addTask(taskCopy)); // Should fail due to task not being unique
	} // Successfully failed
	
	@Test
	void testTaskServiceDeleteFail() {
		String taskDescription = "Botanist will harvest flora on grassy plots";
		
		Task taskDemo = new Task("006", "Harvest", taskDescription);
		
		assertTrue(taskService.addTask(taskDemo)); // Validate if the objects was added
		assertFalse(taskService.deleteTask("007")); // Should fail as no object with this ID exists
	} // Successfully failed

}