package com.example.msformation.API;

import com.example.msformation.proxy.ScolariteProxy;
import com.example.msformation.repository.FormationRepository;
import com.example.msformation.entities.Formation;
import com.example.msformation.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class FormationAPI {

    @Autowired
    FormationRepository formationRepository;

    @Autowired
    ScolariteProxy scolariteProxy;

    @GetMapping("formation/{id}")
    Formation getFormationWithStudent(@PathVariable("id") Long idf)
    {
        Formation formation=formationRepository.findById(idf).get();
        formation.setEtudiants(new ArrayList<>(scolariteProxy.getEtudiants(idf,"toformation").getContent()));
        return formation;
    }
}

