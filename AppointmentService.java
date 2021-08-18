package model;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	
	/** Objects **/
	
	private static Map <String, Appointment> appointments = new HashMap <String, Appointment>();
	private static AppointmentService service = null;
	
	/** Accessor **/
	
	public static AppointmentService getInstance() {
		if (service == null) {
			service = new AppointmentService();
		}
		return service;
	}
	
	public static Appointment getAppointment(String apptId) {
		return appointments.get(apptId);
	}
	
	/** Functions **/
	
	public boolean addAppointment(Appointment appointment) {
		if(appointments.containsKey(appointment.getApptId())) {
			return false; // Key already exists
		}
		appointments.put(appointment.getApptId(), appointment);
		return true; // Key does not exist therefore return true
	}
	
	public boolean deleteAppointment(String apptId) {
		if(appointments.containsKey(apptId)) {
			appointments.remove(apptId);
			return true; // Key found - delete
		}
		return false; // Not key found - nothing to delete.
	}

}