package edu.nugi.repository;

import edu.nugi.entity.VeterinarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeterinarianRepository extends JpaRepository<VeterinarianEntity, Integer> {
    List<VeterinarianEntity> findByAvailable(Byte available);
}
