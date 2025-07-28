package edu.nugi.repository;

import edu.nugi.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<GenderEntity, Integer> {
}
