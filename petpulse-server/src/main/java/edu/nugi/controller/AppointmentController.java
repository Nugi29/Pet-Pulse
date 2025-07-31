package edu.nugi.controller;

import edu.nugi.dto.Appointment;
import edu.nugi.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
@RequiredArgsConstructor
public class AppointmentController {

    final AppointmentService service;

    @GetMapping("/get-all")
    public List<Appointment> getAll() {
        return service.getAllAppointments();
    }

    @GetMapping("/get-by-id/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return service.getAppointmentById(id);
    }

    @GetMapping("/get-by-owner/{ownerId}")
    public List<Appointment> getAppointmentsByOwner(@PathVariable Long ownerId) {
        return service.getAppointmentsByOwnerId(ownerId);
    }

    @GetMapping("/get-by-vet/{vetId}")
    public List<Appointment> getAppointmentsByVet(@PathVariable Long vetId) {
        return service.getAppointmentsByVetId(vetId);
    }

    @PostMapping("/book")
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return service.bookAppointment(appointment);
    }

    @PutMapping("/update-status/{id}")
    public Appointment updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateAppointmentStatus(id, status);
    }

    @DeleteMapping("/cancel/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        service.cancelAppointment(id);
    }
}