package edu.nugi.repository;

import edu.nugi.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<PetEntity, Integer> {
    List<PetEntity> findByOwnerId(Integer ownerId);
}
