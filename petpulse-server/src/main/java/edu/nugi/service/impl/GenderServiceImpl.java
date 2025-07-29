package edu.nugi.service.impl;

import edu.nugi.dto.Gender;
import edu.nugi.entity.GenderEntity;
import edu.nugi.repository.GenderRepository;
import edu.nugi.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenderServiceImpl implements GenderService {

    final GenderRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Gender> getAllGenders() {
        ArrayList<Gender> genderList = new ArrayList<>();
        List<GenderEntity> all = repository.findAll();
        System.out.println(all);
        all.forEach(genderEntity -> {
            genderList.add(mapper.map(genderEntity, Gender.class));
        });

        return genderList;
    }
}
