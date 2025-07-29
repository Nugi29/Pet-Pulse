package edu.nugi.controller;


import edu.nugi.dto.Gender;
import edu.nugi.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genders")
@CrossOrigin
@RequiredArgsConstructor
public class GenderController {

    final GenderService service;

    @RequestMapping("/get-all")
    public List<Gender> getAll() {
        return service.getAllGenders();
    }

}
