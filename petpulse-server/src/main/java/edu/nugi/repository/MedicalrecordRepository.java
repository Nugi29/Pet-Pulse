package edu.nugi.repository;

import edu.nugi.entity.MedicalrecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalrecordRepository extends JpaRepository<MedicalrecordEntity, Integer> {
    List<MedicalrecordEntity> findByPetId(Integer petId);
    List<MedicalrecordEntity> findByVeterinarianId(Integer veterinarianId);
}
