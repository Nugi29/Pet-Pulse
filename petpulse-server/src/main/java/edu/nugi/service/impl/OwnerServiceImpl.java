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
    public Owner createOwner(Owner owner) {
        return null;
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
        return null;
    }

    @Override
    public void deleteOwner(Integer id) {

    }
}
