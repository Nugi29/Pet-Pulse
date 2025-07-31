package edu.nugi.controller;

import edu.nugi.dto.Reminder;
import edu.nugi.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminders")
@CrossOrigin
@RequiredArgsConstructor
public class ReminderController {

    final ReminderService service;

    @GetMapping("/get-all")
    public List<Reminder> getAll() {
        return service.getAllReminders();
    }

    @GetMapping("/get-by-id/{id}")
    public Reminder getReminderById(@PathVariable Integer id) {
        return service.getReminderById(id);
    }

    @GetMapping("/get-by-owner/{ownerId}")
    public List<Reminder> getRemindersByOwner(@PathVariable Integer ownerId) {
        return service.getRemindersByOwnerId(ownerId);
    }

    @GetMapping("/get-pending")
    public List<Reminder> getPendingReminders() {
        return service.getPendingReminders();
    }

    @PostMapping("/create")
    public void createReminder(@RequestBody Reminder reminder) {
        service.createReminder(reminder);
    }

    @PutMapping("/update/{id}")
    public Reminder updateReminder(@PathVariable Integer id, @RequestBody Reminder reminder) {
        return service.updateReminder(id, reminder);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReminder(@PathVariable Integer id) {
        service.deleteReminder(id);
    }
}