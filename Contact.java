package model;

public class Contact {

    /** Fields **/

    private String id = null; // No longer than 10 characters
    private String firstName = null; // No longer than 10 characters
    private String lastName = null; // No longer than 10 characters
    private String phone = null; // Exactly 10 characters
    private String address = null; // No longer than 30 characters

    /** Constructors **/

    private Contact() {}

    public Contact(String id, String firstName, String lastName, String phone, String address) {
    	boolean validId = validate(id, 10);
    	boolean validFirstName = validate(firstName, 10);
    	boolean validLastName = validate(lastName, 10);
    	boolean validPhone = validatePhone(phone, 10);
    	boolean validAddress = validate(address, 30);
    	  	
    	if (validId && validFirstName && validLastName && validPhone && validAddress) {
    		this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.address = address;
            
            return;
    	} else {
    		throw new IllegalArgumentException("< Invalid input >");
    	}
    }

    /** Accessors & Mutators **/

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
    
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    /// Function ///
    
    public boolean validate(String field, int lengthLimit) {
    	boolean valid = false;
    	if (field.length() > lengthLimit) {
    		return valid;
    	}
    	valid = true;
    	return valid;
    }

    public boolean validatePhone(String field, int lengthLimit) {
    	boolean valid = false;
    	if (field.length() != lengthLimit) {
    		return valid;
    	}
    	valid = true;
    	return valid;
    }
    
    @Override
    public String toString(){
        return "ID: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName +
                "\nPhone #: " + phone + "\nAddress: " + address;
    }
}