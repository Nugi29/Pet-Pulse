package edu.nugi.service.impl;

import edu.nugi.dto.Pet;
import edu.nugi.entity.PetEntity;
import edu.nugi.repository.PetRepository;
import edu.nugi.service.PetService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    final PetRepository repository;
    final ModelMapper mapper;

    @Override
    public void createPet(Pet pet) {
        PetEntity petEntity = mapper.map(pet, PetEntity.class);
        repository.save(petEntity);
        System.out.println("Pet created: " + petEntity);
    }

    @Override
    public Pet getPetById(Integer id) {
        Optional<PetEntity> petEntity = repository.findById(id);
        return petEntity.map(entity -> mapper.map(entity, Pet.class)).orElse(null);
    }

    @Override
    public List<Pet> getAllPets() {
        ArrayList<Pet> petList = new ArrayList<>();
        List<PetEntity> all = repository.findAll();
        all.forEach(petEntity -> {
            petList.add(mapper.map(petEntity, Pet.class));
        });
        return petList;
    }

    @Override
    public List<Pet> getPetsByOwnerId(Integer ownerId) {
        ArrayList<Pet> petList = new ArrayList<>();
        List<PetEntity> pets = repository.findByOwnerId(ownerId);
        pets.forEach(petEntity -> {
            petList.add(mapper.map(petEntity, Pet.class));
        });
        return petList;
    }

    @Override
    public Pet updatePet(Integer id, Pet updatedPet) {
        Optional<PetEntity> existingPet = repository.findById(id);
        if (existingPet.isPresent()) {
            PetEntity petEntity = existingPet.get();
            petEntity.setName(updatedPet.getName());
            petEntity.setBreed(updatedPet.getBreed());
            petEntity.setDob(updatedPet.getDob());
            repository.save(petEntity);
            return mapper.map(petEntity, Pet.class);
        }
        return null;
    }

    @Override
    public void deletePet(Integer id) {
        repository.deleteById(id);
    }
}