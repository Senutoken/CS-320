package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import model.Contact;
import model.ContactService;

class ContactServiceTest {
	
	private static ContactService service;
	private static Contact contacts;

	/** JUnit Pass Tests **/
	
	@Test
	void testAddContactPass() {
		Contact contactDemo = new Contact("0001", "Hank", "Hill", "4093051797", "84 Rainey St.");
		
		assertTrue(service.addContact(contactDemo));
	} // Passed successfully
	
	@Test
	void testMultipleContactPass() {
		Contact contact1 = new Contact("0002", "Peggy", "Hill", "4095633770", "84 Rainey St.");
		Contact contact2 = new Contact("0003", "Bobby", "Hill", "4096441221", "84 Rainey St.");
		
		assertTrue(service.addContact(contact1));
		assertTrue(service.addContact(contact2));
	} // Passed successfully
	
	@Test
	void testDeleteContactPass() {
		Contact contactDemo = new Contact("0005", "Dale", "Gribble", "4096560969", "84 Rainey St.");
		
		assertTrue(service.addContact(contactDemo));
		assertTrue(service.deleteContact(contactDemo));
	} // Passed successfully
	
	@Test
	void testUpdateContactPass() {
		Contact contactDemo = new Contact("0006", "Barnie", "Mountain", "4092223030", "48 Cement Ave.");
		String updateFirstName = "Billy";
		String updateLastName = "Hill";
		String updatePhone = "4097773300";
		String updateAddress = "84 Rainey St.";
		
		assertTrue(service.addContact(contactDemo));
		assertTrue(service.updateContact("0006", updateFirstName, updateLastName, updatePhone, updateAddress));
	} // Passed successfully
		
	/** JUnit Fail Tests **/
	
	@Test
	void testAddContactFail() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("1000000000000000000000", "Hank", "Hill", "4093051797", "84 Rainey St.");
			  new Contact("2000", "Hankkkkkkkkkkkkkkkkkkk", "Hill", "4093051797", "84 Rainey St.");
			  new Contact("3000", "Hank", "Hillllllllllllllllllll", "4093051797", "84 Rainey St.");
			  new Contact("4000", "Hank", "Hill", "4093051797777777777777777777", "84 Rainey St.");
			  new Contact("5000", "Hank", "Hill", "4093051797", "84 Rainey Stttttttttttttttttttttttttttttttttttttttttttttttttttttt.");
		});
	} // Failed successfully
	
	
	@Test
	void testMultipleContactFail() {
		Contact contactDemo = new Contact("6000", "Bill", "Dauterive", "4090091123", "85 Waterfall St.");
		Contact copyDemo = new Contact("6000", "Bill", "Dauterive", "4090091123", "85 Waterfall St.");
		
		assertTrue(service.addContact(contactDemo));
		assertFalse(service.addContact(copyDemo));
	} // Failed successfully
	
	@Test
	void testDeleteContactFail() {
		Contact contactDemo = new Contact("8000", "Jimmy", "Beardon", "4092198877", "Cove 10th Ave.");
		assertFalse(service.deleteContact(contactDemo));
	} // Failed successfully
	
	@Test
	void testUpdateContactFail() {
		assertFalse(service.updateContact("9999", "Yogi", "Victor", "1234567890", "105r3n ejnfe StT."));
	} // Failed successfully
	
	
}