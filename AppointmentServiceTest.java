package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import model.Appointment;
import model.AppointmentService;


class AppointmentServiceTest {
	
	/** Objects **/
	
	AppointmentService service = AppointmentService.getInstance();
	Date currentDate = new Date();

	/** Test Pass **/
	
	@Test
	void testServiceCreationPass() {
		String description = "Graduation ceremony";
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 9);
		c.set(Calendar.DATE, 26);
		c.set(Calendar.YEAR, 2022);
		
		Date date1 = c.getTime();
		
		Appointment apptDemo = new Appointment("0002", description, date1);
		service.addAppointment(apptDemo);
		Appointment apptCopy = service.getAppointment("0002");
		
		assertTrue(apptCopy.getApptId().equals(apptDemo.getApptId()));
		assertTrue(apptCopy.getApptDescription().equals(apptDemo.getApptDescription()));
		assertTrue(apptCopy.getDate().equals(apptDemo.getDate()));
	} // Passed successfully
	
	@Test
	void testServiceAddPass() {
		String description1 = "Graduation ceremony";
		String description2 = "Doctor's appointment";
		String description3 = "Birthday party";
		
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.MONTH, 2);
		c1.set(Calendar.DATE, 13);
		c1.set(Calendar.YEAR, 2022);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.MONTH, 5);
		c2.set(Calendar.DATE, 18);
		c2.set(Calendar.YEAR, 2023);
		
		Calendar c3 = Calendar.getInstance();
		c3.set(Calendar.MONTH, 11);
		c3.set(Calendar.DATE, 30);
		c3.set(Calendar.YEAR, 2021);
	
		Date date1 = c1.getTime();
		Date date2 = c2.getTime();
		Date date3 = c3.getTime();
		
		Appointment appt1 = new Appointment("0100", description1, date1);
		Appointment appt2 = new Appointment("0101", description2, date2);
		Appointment appt3 = new Appointment("0102", description3, date3);
		
		assertTrue(service.addAppointment(appt1));
		assertTrue(service.addAppointment(appt2));
		assertTrue(service.addAppointment(appt3));
	} // Passed successfully
	
	@Test
	void testServiceDeletePass() {
		String description = "Car maintenance";
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 5);
		c.set(Calendar.DATE, 07);
		c.set(Calendar.YEAR, 2024);
		
		Date dateDemo = c.getTime();
		Appointment apptDemo = new Appointment("0200", description, dateDemo);
		
		service.addAppointment(apptDemo);
		
		assertTrue(service.deleteAppointment(apptDemo.getApptId()));	
	} // Passed successfully
	
	/** Test Fail **/
	
	@Test
	void testServiceCreationFail() {
		String description = "Full Marathon race";
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 1);
		c.set(Calendar.DATE, 23);
		c.set(Calendar.YEAR, 2023);
		
		Date dateDemo = c.getTime();
		Appointment apptDemo = new Appointment("0500", description, dateDemo);
		service.addAppointment(apptDemo);
		Appointment apptCopy = service.getAppointment("0500");
		
		assertFalse(service.addAppointment(apptCopy));
	} // Successfully failed
	
	@Test
	void testServiceAddFail() {
		String id = "1000";
		
		String description1 = "First day of work";
		String description2 = "Second day of work";
		
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.MONTH, 1);
		c1.set(Calendar.DATE, 03);
		c1.set(Calendar.YEAR, 2022);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.MONTH, 1);
		c2.set(Calendar.DATE, 04);
		c2.set(Calendar.YEAR, 2022);
		
		Date date1 = c1.getTime();
		Date date2 = c2.getTime();
		
		Appointment appt1 = new Appointment(id, description1, date1);
		Appointment appt2 = new Appointment(id, description2, date2);
		
		assertTrue(service.addAppointment(appt1));
		assertFalse(service.addAppointment(appt2));
	} // Successfully Failed
	
	@Test
	void testServiceDeleteFail() {
		String id = "0503";
		String description = "Go on date";
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 2);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2022);
		
		Date dateDemo = c.getTime();
		Appointment apptDemo = new Appointment(id, description, dateDemo);
		
		service.addAppointment(apptDemo);
		
		assertFalse(service.deleteAppointment("0703"));
	}
}
