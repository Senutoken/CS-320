package model;

import java.util.HashMap;

public class ContactService {

    /** Objects **/
	
    private static HashMap<String, Contact> contactList = new HashMap<String, Contact>(); // < ID, Contact >

    /** Functions **/
    
    public static boolean addContact(Contact contact) {
    	if (contactList.containsKey(contact.getId())) {
    		return false;
    	} else {
    		contactList.put(contact.getId(), contact);
    		return true;
    	}
    }
    
    public static boolean deleteContact(Contact contact){
    	if (contactList.containsKey(contact.getId())) {
    		contactList.remove(contact.getId());
    		return true;
    	} else {
    		return false;
    	}
    }

    public static boolean updateContact(String contactId, String fName, String lName, String phone, String address){
    	if (contactList.containsKey(contactId)) {
    		contactList.get(contactId).setFirstName(fName);
    		contactList.get(contactId).setLastName(lName);
    		contactList.get(contactId).setPhone(phone);
    		contactList.get(contactId).setAddress(address);
    		
    		return true;
    	}
    	return false;
    }
      
    public Contact getContact(String contactID) {
    	return contactList.get(contactID); // Returns the contact object with matching ID.
    	}
}