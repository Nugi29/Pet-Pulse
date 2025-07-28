package edu.nugi.repository;

import edu.nugi.entity.ReminderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<ReminderEntity, Integer> {
}
