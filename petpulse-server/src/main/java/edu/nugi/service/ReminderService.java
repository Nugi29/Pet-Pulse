package edu.nugi.service;

import edu.nugi.dto.Reminder;

import java.util.List;

public interface ReminderService {
    void createReminder(Reminder reminder);
    Reminder getReminderById(Integer id);
    List<Reminder> getAllReminders();
    List<Reminder> getRemindersByOwnerId(Integer ownerId);
    List<Reminder> getPendingReminders();
    Reminder updateReminder(Integer id, Reminder updatedReminder);
    void deleteReminder(Integer id);
}