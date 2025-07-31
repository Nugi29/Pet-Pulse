package edu.nugi.repository;

import edu.nugi.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
    List<AppointmentEntity> findByPetOwnerId(Integer ownerId);
    List<AppointmentEntity> findByVeterinarianId(Integer veterinarianId);
}
