package edu.nugi.repository;

import edu.nugi.entity.ReminderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<ReminderEntity, Integer> {
    List<ReminderEntity> findByOwnerId(Integer ownerId);
    List<ReminderEntity> findByStatus(String status);
}
