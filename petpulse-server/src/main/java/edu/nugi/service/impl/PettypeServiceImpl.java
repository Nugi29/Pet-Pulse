package edu.nugi.service.impl;

import edu.nugi.dto.Pettype;
import edu.nugi.entity.PettypeEntity;
import edu.nugi.repository.PettypeRepository;
import edu.nugi.service.PettypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PettypeServiceImpl implements PettypeService {

    final PettypeRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Pettype> getAllPettypes() {
        ArrayList<Pettype> pettypeList = new ArrayList<>();
        List<PettypeEntity> all = repository.findAll();
        System.out.println(all);
        all.forEach(pettypeEntity -> {
            pettypeList.add(mapper.map(pettypeEntity, Pettype.class));
        });

        return pettypeList;
    }
}
