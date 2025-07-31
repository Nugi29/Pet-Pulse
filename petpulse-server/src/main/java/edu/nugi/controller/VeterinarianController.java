package edu.nugi.controller;

import edu.nugi.dto.Veterinarian;
import edu.nugi.service.VeterinarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarians")
@CrossOrigin
@RequiredArgsConstructor
public class VeterinarianController {

    final VeterinarianService service;

    @GetMapping("/get-all")
    public List<Veterinarian> getAll() {
        return service.getAllVeterinarians();
    }

    @GetMapping("/get-available")
    public List<Veterinarian> getAvailable() {
        return service.getAvailableVeterinarians();
    }

    @GetMapping("/get-by-id/{id}")
    public Veterinarian getVeterinarianById(@PathVariable Integer id) {
        return service.getVeterinarianById(id);
    }

    @PostMapping("/create")
    public void createVeterinarian(@RequestBody Veterinarian veterinarian) {
        service.createVeterinarian(veterinarian);
    }

    @PutMapping("/update/{id}")
    public Veterinarian updateVeterinarian(@PathVariable Integer id, @RequestBody Veterinarian veterinarian) {
        return service.updateVeterinarian(id, veterinarian);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVeterinarian(@PathVariable Integer id) {
        service.deleteVeterinarian(id);
    }
}