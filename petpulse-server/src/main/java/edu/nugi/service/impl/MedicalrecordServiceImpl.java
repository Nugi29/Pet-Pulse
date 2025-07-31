package edu.nugi.service.impl;

import edu.nugi.dto.Medicalrecord;
import edu.nugi.entity.MedicalrecordEntity;
import edu.nugi.repository.MedicalrecordRepository;
import edu.nugi.service.MedicalrecordService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalrecordServiceImpl implements MedicalrecordService {

    final MedicalrecordRepository repository;
    final ModelMapper mapper;

    @Override
    public void createMedicalRecord(Medicalrecord medicalrecord) {
        MedicalrecordEntity recordEntity = mapper.map(medicalrecord, MedicalrecordEntity.class);
        repository.save(recordEntity);
        System.out.println("Medical record created: " + recordEntity);
    }

    @Override
    public Medicalrecord getMedicalRecordById(Integer id) {
        Optional<MedicalrecordEntity> recordEntity = repository.findById(id);
        return recordEntity.map(entity -> mapper.map(entity, Medicalrecord.class)).orElse(null);
    }

    @Override
    public List<Medicalrecord> getAllMedicalRecords() {
        ArrayList<Medicalrecord> recordList = new ArrayList<>();
        List<MedicalrecordEntity> all = repository.findAll();
        all.forEach(recordEntity -> {
            recordList.add(mapper.map(recordEntity, Medicalrecord.class));
        });
        return recordList;
    }

    @Override
    public List<Medicalrecord> getMedicalRecordsByPetId(Integer petId) {
        ArrayList<Medicalrecord> recordList = new ArrayList<>();
        List<MedicalrecordEntity> records = repository.findByPetId(petId);
        records.forEach(recordEntity -> {
            recordList.add(mapper.map(recordEntity, Medicalrecord.class));
        });
        return recordList;
    }

    @Override
    public List<Medicalrecord> getMedicalRecordsByVetId(Integer vetId) {
        ArrayList<Medicalrecord> recordList = new ArrayList<>();
        List<MedicalrecordEntity> records = repository.findByVeterinarianId(vetId);
        records.forEach(recordEntity -> {
            recordList.add(mapper.map(recordEntity, Medicalrecord.class));
        });
        return recordList;
    }

    @Override
    public Medicalrecord updateMedicalRecord(Integer id, Medicalrecord updatedRecord) {
        Optional<MedicalrecordEntity> existingRecord = repository.findById(id);
        if (existingRecord.isPresent()) {
            MedicalrecordEntity recordEntity = existingRecord.get();
            recordEntity.setDiagnosis(updatedRecord.getDiagnosis());
            recordEntity.setTreatment(updatedRecord.getTreatment());
            recordEntity.setVaccinations(updatedRecord.getVaccinations());
            recordEntity.setVisitDate(updatedRecord.getVisitDate());
            repository.save(recordEntity);
            return mapper.map(recordEntity, Medicalrecord.class);
        }
        return null;
    }

    @Override
    public void deleteMedicalRecord(Integer id) {
        repository.deleteById(id);
    }
}