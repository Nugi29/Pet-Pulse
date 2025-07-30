package edu.nugi.service;

import edu.nugi.dto.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);

    Appointment getAppointmentById(Long id);

    List<Appointment> getAppointmentsByOwnerId(Long ownerId);

    List<Appointment> getAppointmentsByVetId(Long vetId);

    List<Appointment> getAllAppointments();

    Appointment updateAppointmentStatus(Long id, String status);

    void cancelAppointment(Long id);

}
