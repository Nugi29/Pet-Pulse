package edu.nugi.service;

import edu.nugi.dto.Veterinarian;

import java.util.List;

public interface VeterinarianService {
    void createVeterinarian(Veterinarian veterinarian);
    Veterinarian getVeterinarianById(Integer id);
    List<Veterinarian> getAllVeterinarians();
    List<Veterinarian> getAvailableVeterinarians();
    Veterinarian updateVeterinarian(Integer id, Veterinarian updatedVeterinarian);
    void deleteVeterinarian(Integer id);
}