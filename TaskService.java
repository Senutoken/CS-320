package model;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
	/** Objects **/
	private static TaskService service = null;
	private final Map <String, Task> taskList = new HashMap<String, Task>();

	/** Constructor **/
	
	private TaskService() {} // Prevents new instantiations.
	
	/** Accessor **/
	
	public static TaskService getInstance() { // Singleton function.
		if (service == null) {
			service = new TaskService();
		}
		return service;
	}
	
	/** Functions **/
	
	public boolean addTask(Task task) {
		boolean validation = false;
		
		if (!taskList.containsKey(task.getId())) {
			taskList.put(task.getId(), task);
			validation = true;
		}
		return validation;
	}
	
	public boolean deleteTask(String taskId) {
		boolean validation = false;
		
		if (taskList.containsKey(taskId)) {
			taskList.remove(taskId);
			validation = true; // Task was successfully removed.
		}
		return validation; // Failed to remove task.
	}
	
	public boolean updateTask(Task task, String name, String description) {
		if (taskList.containsKey(task.getId())) {
			taskList.get(task.getId()).setName(name);
			taskList.get(task.getId()).setDescription(description);
			
			return true;
		}
		return false;
	}

	public Task getTask(String taskId) {
		return taskList.get(taskId);
	}
}
