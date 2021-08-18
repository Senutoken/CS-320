package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import model.Contact;

class ContactTest {

	@Test
	void testContactPass() {
		Contact contactObj = new Contact("01121997", "Hank", "Hill", "4093051797", "84 Rainey St.");
		assertTrue(contactObj.getId().equals("01121997"));
		assertTrue(contactObj.getFirstName().equals("Hank"));
		assertTrue(contactObj.getLastName().equals("Hill"));
		assertTrue(contactObj.getPhone().equals("4093051797"));
		assertTrue(contactObj.getAddress().equals("84 Rainey St."));   
	} // Correctly passed.
	
	
	@Test
	void testContactIdFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("01121997000000000", "Hank", "Hill", "4093051797", "84 Rainey St.");
		    });	// Correct fails.
	}
	
	@Test
	void testContacFirstNameFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("01121997", "Hankkkkkkkkkkkkkkkkkkkkkkk", "Hill", "4093051797", "84 Rainey St.");
		    });	// Correctly fails.
	}
	
	@Test
	void testContacLastNameFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("01121997", "Hank", "Hillllllllllllllllllllllll", "4093051797", "84 Rainey St.");
		    });	// Correctly fails.
	}
	
	@Test
	void testContatcPhoneFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("01121997", "Hank", "Hil", "409305179777777777777777777777", "84 Rainey St.");
		    });	// Correctly fails.
	}
	
	@Test
	void testContatcAddressFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Contact("01121997", "Hank", "Hil", "4093051797", "84 Rainey St. Texassssssssssssssssssssssssssssssssssssssss");
		    });	// Correctly fails.
	}
}
