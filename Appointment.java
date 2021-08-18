package model;

import java.util.Date;

public class Appointment {
	
	/** Fields **/
	
	private String apptId = null;
	private String apptDescription = null;
	private Date assignedDate = null;
	private Date currentDate = new Date();
	
	/** Constructor **/
	
	public Appointment(String id, String description, Date date) {
		boolean validId = validateString(id, 10);
		boolean validDescription = validateString(description, 50);
		boolean validDate = validateDate(date);
		
		if (validId && validDescription && validDate) {
			this.apptId = id;
			this.apptDescription = description;
			this.assignedDate = date;
		} else {
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	/** Accessors & Mutators **/
	
	public String getApptId() { return this.apptId;}
	
	public String getApptDescription() { return this.apptDescription;}
	
	public Date getDate() { return this.assignedDate;}
	
	
	public void setApptId(String id) { this.apptId = id;}
	
	public void setApptDescription(String description) { this.apptDescription = description;}
	
	public void setDate(Date date) { this.assignedDate = date;}
	
	/** Functions **/
	
	public boolean validateString(String field, int lengthLimit) {
		boolean valid = false; // false by default
		
		if(field.length() <= lengthLimit) {
			valid = true;
		}
		return valid;
	}
	
	public boolean validateDate(Date futureDate) {
		return this.currentDate.before(futureDate);
	}

}
