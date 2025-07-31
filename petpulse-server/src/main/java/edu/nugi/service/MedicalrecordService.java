package edu.nugi.service;

import edu.nugi.dto.Medicalrecord;

import java.util.List;

public interface MedicalrecordService {
    void createMedicalRecord(Medicalrecord medicalrecord);
    Medicalrecord getMedicalRecordById(Integer id);
    List<Medicalrecord> getAllMedicalRecords();
    List<Medicalrecord> getMedicalRecordsByPetId(Integer petId);
    List<Medicalrecord> getMedicalRecordsByVetId(Integer vetId);
    Medicalrecord updateMedicalRecord(Integer id, Medicalrecord updatedRecord);
    void deleteMedicalRecord(Integer id);
}