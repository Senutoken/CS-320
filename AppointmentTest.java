package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import model.Appointment;

class AppointmentTest {
	
	Date currentDate = new Date();

	/** Test Pass **/
	
	@Test
	void testAppointmentCreationPass() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 1);
		c.set(Calendar.DATE, 12);
		c.set(Calendar.YEAR, 2022);
		
		Date date1 = c.getTime();
		
		Appointment apptObj = new Appointment("0001", "Class graduation", date1);
		
		assertTrue(apptObj != null);
		assertTrue(apptObj.getApptId().equals("0001"));
		assertTrue(apptObj.getApptDescription().equals("Class graduation"));
		assertTrue(apptObj.getDate().equals(date1));
	} // Successfully passed
	
	/** Test Fail **/
	
	@Test
	void testAppointmentIdFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("012345678901234567890", "Class graduation", currentDate);
		}); 
	} // Failed successfully

	@Test
	void testAppointmentDescriptionFail() {
		String description = "Class graduation will take place sometime "
				+ "next year in 2022. If I am able to fit one more class"
				+ "this year, I might just be able to graduate before 2022. "
				+ "This is difficult though, since most of my classes are "
				+ "pre-requisites for the other.";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0001", description, currentDate);
		}); 
	} // Failed successfully

	@Test
	void testAppointmentDateFail() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 8);
		c.set(Calendar.DATE, 13);
		c.set(Calendar.YEAR, 2004);
		
		Date datePast = c.getTime();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0001", "Class graduation", datePast);
		}); 
	} // Failed successfully

}
