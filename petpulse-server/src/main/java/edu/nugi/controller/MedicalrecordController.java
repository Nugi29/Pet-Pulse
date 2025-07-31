package edu.nugi.controller;

import edu.nugi.dto.Medicalrecord;
import edu.nugi.service.MedicalrecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-records")
@CrossOrigin
@RequiredArgsConstructor
public class MedicalrecordController {

    final MedicalrecordService service;

    @GetMapping("/get-all")
    public List<Medicalrecord> getAll() {
        return service.getAllMedicalRecords();
    }

    @GetMapping("/get-by-id/{id}")
    public Medicalrecord getMedicalRecordById(@PathVariable Integer id) {
        return service.getMedicalRecordById(id);
    }

    @GetMapping("/get-by-pet/{petId}")
    public List<Medicalrecord> getMedicalRecordsByPet(@PathVariable Integer petId) {
        return service.getMedicalRecordsByPetId(petId);
    }

    @GetMapping("/get-by-vet/{vetId}")
    public List<Medicalrecord> getMedicalRecordsByVet(@PathVariable Integer vetId) {
        return service.getMedicalRecordsByVetId(vetId);
    }

    @PostMapping("/create")
    public void createMedicalRecord(@RequestBody Medicalrecord medicalrecord) {
        service.createMedicalRecord(medicalrecord);
    }

    @PutMapping("/update/{id}")
    public Medicalrecord updateMedicalRecord(@PathVariable Integer id, @RequestBody Medicalrecord medicalrecord) {
        return service.updateMedicalRecord(id, medicalrecord);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicalRecord(@PathVariable Integer id) {
        service.deleteMedicalRecord(id);
    }
}