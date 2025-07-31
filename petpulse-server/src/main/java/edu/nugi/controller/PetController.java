package edu.nugi.controller;

import edu.nugi.dto.Pet;
import edu.nugi.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@CrossOrigin
@RequiredArgsConstructor
public class PetController {

    final PetService service;

    @GetMapping("/get-all")
    public List<Pet> getAll() {
        return service.getAllPets();
    }

    @GetMapping("/get-by-id/{id}")
    public Pet getPetById(@PathVariable Integer id) {
        return service.getPetById(id);
    }

    @GetMapping("/get-by-owner/{ownerId}")
    public List<Pet> getPetsByOwner(@PathVariable Integer ownerId) {
        return service.getPetsByOwnerId(ownerId);
    }

    @PostMapping("/create")
    public void createPet(@RequestBody Pet pet) {
        service.createPet(pet);
    }

    @PutMapping("/update/{id}")
    public Pet updatePet(@PathVariable Integer id, @RequestBody Pet pet) {
        return service.updatePet(id, pet);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePet(@PathVariable Integer id) {
        service.deletePet(id);
    }
}