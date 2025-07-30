package edu.nugi.service;

import edu.nugi.dto.Owner;

import java.util.List;

public interface OwnerService {

    void createOwner(Owner owner);

    Owner getOwnerById(Integer id);

    List<Owner> getAllOwners();

    Owner updateOwner(Integer id, Owner updatedOwner);

    void deleteOwner(Integer id);

}
