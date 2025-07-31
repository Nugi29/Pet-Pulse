package edu.nugi.service;

import edu.nugi.dto.Pet;

import java.util.List;

public interface PetService {
    void createPet(Pet pet);
    Pet getPetById(Integer id);
    List<Pet> getAllPets();
    List<Pet> getPetsByOwnerId(Integer ownerId);
    Pet updatePet(Integer id, Pet updatedPet);
    void deletePet(Integer id);
}