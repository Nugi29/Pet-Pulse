package edu.nugi.service.impl;

import edu.nugi.dto.Owner;
import edu.nugi.entity.OwnerEntity;
import edu.nugi.repository.OwnerRepository;
import edu.nugi.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    final OwnerRepository repository;
    final ModelMapper mapper;

    @Override
    public void createOwner(Owner owner) {
//        repository.save(mapper.map(owner, OwnerEntity.class));
        OwnerEntity ownerEntity = mapper.map(owner, OwnerEntity.class);
        repository.save(ownerEntity);
        System.out.println("Owner created: " + ownerEntity);
    }

    @Override
    public Owner getOwnerById(Integer id) {
        return mapper.map(repository.findById(id), Owner.class);
    }

    @Override
    public List<Owner> getAllOwners() {
        ArrayList<Owner> ownerList = new ArrayList<>();
        List<OwnerEntity> all = repository.findAll();
        System.out.println(all);
        all.forEach(ownerEntity -> {
            ownerList.add(mapper.map(ownerEntity, Owner.class));
        });

        return ownerList;
    }

    @Override
    public Owner updateOwner(Integer id, Owner updatedOwner) {
        OwnerEntity existingOwnerEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        mapper.map(updatedOwner, existingOwnerEntity);
        OwnerEntity savedEntity = repository.save(existingOwnerEntity);
        return mapper.map(savedEntity, Owner.class);

    }

    @Override
    public void deleteOwner(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Owner not found");
        }
        repository.deleteById(id);
        System.out.println("Owner with ID " + id + " deleted successfully.");

    }
}
