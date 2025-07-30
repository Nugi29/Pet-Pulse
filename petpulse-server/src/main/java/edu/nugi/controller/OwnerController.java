package edu.nugi.controller;


import edu.nugi.dto.Owner;
import edu.nugi.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@CrossOrigin
@RequiredArgsConstructor
public class OwnerController {

    final OwnerService service;

    @GetMapping("/get-all")
    public List<Owner> getAll() {
        return service.getAllOwners();
    }

    @GetMapping("/get-by-id/{id}")
    public Owner getOwnerById(@PathVariable Integer id) {
        return service.getOwnerById(id);
    }

    @PostMapping("/create")
    public void createOwner(@RequestBody Owner owner) {
        service.createOwner(owner);
    }

}
