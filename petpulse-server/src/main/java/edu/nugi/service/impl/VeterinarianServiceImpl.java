package edu.nugi.service.impl;

import edu.nugi.dto.Veterinarian;
import edu.nugi.entity.VeterinarianEntity;
import edu.nugi.repository.VeterinarianRepository;
import edu.nugi.service.VeterinarianService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeterinarianServiceImpl implements VeterinarianService {

    final VeterinarianRepository repository;
    final ModelMapper mapper;

    @Override
    public void createVeterinarian(Veterinarian veterinarian) {
        VeterinarianEntity vetEntity = mapper.map(veterinarian, VeterinarianEntity.class);
        repository.save(vetEntity);
        System.out.println("Veterinarian created: " + vetEntity);
    }

    @Override
    public Veterinarian getVeterinarianById(Integer id) {
        Optional<VeterinarianEntity> vetEntity = repository.findById(id);
        return vetEntity.map(entity -> mapper.map(entity, Veterinarian.class)).orElse(null);
    }

    @Override
    public List<Veterinarian> getAllVeterinarians() {
        ArrayList<Veterinarian> vetList = new ArrayList<>();
        List<VeterinarianEntity> all = repository.findAll();
        all.forEach(vetEntity -> {
            vetList.add(mapper.map(vetEntity, Veterinarian.class));
        });
        return vetList;
    }

    @Override
    public List<Veterinarian> getAvailableVeterinarians() {
        ArrayList<Veterinarian> vetList = new ArrayList<>();
        List<VeterinarianEntity> available = repository.findByAvailable((byte) 1);
        available.forEach(vetEntity -> {
            vetList.add(mapper.map(vetEntity, Veterinarian.class));
        });
        return vetList;
    }

    @Override
    public Veterinarian updateVeterinarian(Integer id, Veterinarian updatedVeterinarian) {
        Optional<VeterinarianEntity> existingVet = repository.findById(id);
        if (existingVet.isPresent()) {
            VeterinarianEntity vetEntity = existingVet.get();
            vetEntity.setName(updatedVeterinarian.getName());
            vetEntity.setEmail(updatedVeterinarian.getEmail());
            vetEntity.setPhone(updatedVeterinarian.getPhone());
            vetEntity.setSpecialization(updatedVeterinarian.getSpecialization());
            vetEntity.setAvailable(updatedVeterinarian.getAvailable());
            repository.save(vetEntity);
            return mapper.map(vetEntity, Veterinarian.class);
        }
        return null;
    }

    @Override
    public void deleteVeterinarian(Integer id) {
        repository.deleteById(id);
    }
}