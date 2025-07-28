package edu.nugi.repository;

import edu.nugi.entity.VeterinarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository extends JpaRepository<VeterinarianEntity, Integer> {
}
