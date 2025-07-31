package edu.nugi.service.impl;

import edu.nugi.dto.Appointment;
import edu.nugi.entity.AppointmentEntity;
import edu.nugi.repository.AppointmentRepository;
import edu.nugi.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    final AppointmentRepository repository;
    final ModelMapper mapper;

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        AppointmentEntity appointmentEntity = mapper.map(appointment, AppointmentEntity.class);
        AppointmentEntity saved = repository.save(appointmentEntity);
        return mapper.map(saved, Appointment.class);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        Optional<AppointmentEntity> appointmentEntity = repository.findById(id.intValue());
        return appointmentEntity.map(entity -> mapper.map(entity, Appointment.class)).orElse(null);
    }

    @Override
    public List<Appointment> getAppointmentsByOwnerId(Long ownerId) {
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        List<AppointmentEntity> appointments = repository.findByPetOwnerId(ownerId.intValue());
        appointments.forEach(appointmentEntity -> {
            appointmentList.add(mapper.map(appointmentEntity, Appointment.class));
        });
        return appointmentList;
    }

    @Override
    public List<Appointment> getAppointmentsByVetId(Long vetId) {
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        List<AppointmentEntity> appointments = repository.findByVeterinarianId(vetId.intValue());
        appointments.forEach(appointmentEntity -> {
            appointmentList.add(mapper.map(appointmentEntity, Appointment.class));
        });
        return appointmentList;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        List<AppointmentEntity> all = repository.findAll();
        all.forEach(appointmentEntity -> {
            appointmentList.add(mapper.map(appointmentEntity, Appointment.class));
        });
        return appointmentList;
    }

    @Override
    public Appointment updateAppointmentStatus(Long id, String status) {
        Optional<AppointmentEntity> existingAppointment = repository.findById(id.intValue());
        if (existingAppointment.isPresent()) {
            AppointmentEntity appointmentEntity = existingAppointment.get();
            appointmentEntity.setStatus(status);
            repository.save(appointmentEntity);
            return mapper.map(appointmentEntity, Appointment.class);
        }
        return null;
    }

    @Override
    public void cancelAppointment(Long id) {
        updateAppointmentStatus(id, "CANCELLED");
    }
}