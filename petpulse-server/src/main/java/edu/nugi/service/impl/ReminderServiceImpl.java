package edu.nugi.service.impl;

import edu.nugi.dto.Reminder;
import edu.nugi.entity.ReminderEntity;
import edu.nugi.repository.ReminderRepository;
import edu.nugi.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReminderServiceImpl implements ReminderService {

    final ReminderRepository repository;
    final ModelMapper mapper;

    @Override
    public void createReminder(Reminder reminder) {
        ReminderEntity reminderEntity = mapper.map(reminder, ReminderEntity.class);
        repository.save(reminderEntity);
        System.out.println("Reminder created: " + reminderEntity);
    }

    @Override
    public Reminder getReminderById(Integer id) {
        Optional<ReminderEntity> reminderEntity = repository.findById(id);
        return reminderEntity.map(entity -> mapper.map(entity, Reminder.class)).orElse(null);
    }

    @Override
    public List<Reminder> getAllReminders() {
        ArrayList<Reminder> reminderList = new ArrayList<>();
        List<ReminderEntity> all = repository.findAll();
        all.forEach(reminderEntity -> {
            reminderList.add(mapper.map(reminderEntity, Reminder.class));
        });
        return reminderList;
    }

    @Override
    public List<Reminder> getRemindersByOwnerId(Integer ownerId) {
        ArrayList<Reminder> reminderList = new ArrayList<>();
        List<ReminderEntity> reminders = repository.findByOwnerId(ownerId);
        reminders.forEach(reminderEntity -> {
            reminderList.add(mapper.map(reminderEntity, Reminder.class));
        });
        return reminderList;
    }

    @Override
    public List<Reminder> getPendingReminders() {
        ArrayList<Reminder> reminderList = new ArrayList<>();
        List<ReminderEntity> pending = repository.findByStatus("PENDING");
        pending.forEach(reminderEntity -> {
            reminderList.add(mapper.map(reminderEntity, Reminder.class));
        });
        return reminderList;
    }

    @Override
    public Reminder updateReminder(Integer id, Reminder updatedReminder) {
        Optional<ReminderEntity> existingReminder = repository.findById(id);
        if (existingReminder.isPresent()) {
            ReminderEntity reminderEntity = existingReminder.get();
            reminderEntity.setTitle(updatedReminder.getTitle());
            reminderEntity.setMessage(updatedReminder.getMessage());
            reminderEntity.setReminderDate(updatedReminder.getReminderDate());
            reminderEntity.setType(updatedReminder.getType());
            reminderEntity.setStatus(updatedReminder.getStatus());
            repository.save(reminderEntity);
            return mapper.map(reminderEntity, Reminder.class);
        }
        return null;
    }

    @Override
    public void deleteReminder(Integer id) {
        repository.deleteById(id);
    }
}