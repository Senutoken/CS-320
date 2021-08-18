package model;

public class Task {
	private String id = null;
	private String name = null;
	private String description = null;
	
	/** Constructors **/
	
	public Task(String id, String name, String description) {
		boolean validId = validateTask(id, 10);
		boolean validName = validateTask(name, 20);
		boolean validDescription = validateTask(description, 50);
		
		if (validId) {
			this.id = id;
		}
		if (validName) {
			this.name = name;
		}
		if (validDescription) {
			this.description = description;
		}
		if (!validId || !validName || !validDescription) {
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	/** Accessors & Mutators **/

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }
	
	/** Function **/
	
	public boolean validateTask(String taskField, int lengthLimit) {
		boolean validation = false; // Return true if field meets requirements
		
		if (taskField.length() <= lengthLimit && taskField != null) {
			validation = true;
		}
		return validation;
	}
}
