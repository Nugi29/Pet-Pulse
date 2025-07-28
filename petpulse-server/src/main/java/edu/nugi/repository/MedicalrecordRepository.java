package edu.nugi.repository;

import edu.nugi.entity.MedicalrecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalrecordRepository extends JpaRepository<MedicalrecordEntity, Integer> {
}
