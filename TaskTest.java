package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Task;

class TaskTest {

	/** JUnit Tests **/
	
	@Test 
	void testTaskCreationPass() {
		String taskDescription = "Botanist will harvest flora on grassy plots";
		Task taskDemo = new Task("001", "Harvest", taskDescription);
		
		assertTrue(taskDemo != null);
		assertTrue(taskDemo.getId().equals("001")); // Verify id matches
		assertTrue(taskDemo.getName().equals("Harvest")); // Verify name matches
		assertTrue(taskDemo.getDescription().equals(taskDescription)); // Verify description matches
	} // Passed successfully
	
	/** JUnit Tests (Fail) **/
	
	@Test
	void testTaskIdFail() {
		String taskDescription = "Botanist will harvest flora on grassy plots";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("0000000000000000000000001", "Harvest", taskDescription);
		}); // Failed successfully
	}
	
	@Test
	void testTaskNameFail() {
		String taskDescription = "Botanist will harvest flora on grassy plots";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("001", "Harvest all the flowers and grass", taskDescription);
		}); // Failed successfully
	}
	
	@Test
	void testTaskDescriptionFail() {
		String taskDescription = "Botanist will harvest on grassy plots and provide additional treatments to endangered flora";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("001", "Harvest", taskDescription);
		}); // Failed successfully
	}
}