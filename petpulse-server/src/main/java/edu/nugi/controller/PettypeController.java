package edu.nugi.controller;


import edu.nugi.dto.Pettype;
import edu.nugi.service.PettypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pettypes")
@CrossOrigin
@RequiredArgsConstructor
public class PettypeController {

    final PettypeService service;

    @RequestMapping("/get-all")
    public List<Pettype> getAll() {
        return service.getAllPettypes();
    }

}
