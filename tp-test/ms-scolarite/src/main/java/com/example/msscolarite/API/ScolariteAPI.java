package com.example.msscolarite.API;


import com.example.msscolarite.entities.Etudiant;
import com.example.msscolarite.proxy.BourseProxy;
import com.example.msscolarite.proxy.FormationProxy;
import com.example.msscolarite.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ScolariteAPI {

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    FormationProxy formationProxy;

    @Autowired
    BourseProxy bourseProxy;

    @GetMapping("etudiants/{id}")
    Etudiant getEtudiantwithFormation(@PathVariable("id") Long ide){
        Etudiant etudiant=etudiantRepository.findById(ide).get();
        etudiant.setFormation(formationProxy.getFormation(etudiant.getIdFormation()));
        return etudiant;
    }

    @GetMapping("etudiants")
    List<Etudiant> GetEtudiantswithFormation(){
        List<Etudiant> etudiants=etudiantRepository.findAll();
        etudiants.forEach((e)->{
            e.setFormation(formationProxy.getFormation(e.getIdFormation()));
        });

        return etudiants;
    }

    @GetMapping("etudiantsVir/{id}")
    Etudiant getVirementsOfEtudiant(@PathVariable("id") Long ide)
    {
        Etudiant etudiant = etudiantRepository.findById(ide).get();
        etudiant.setVirements(new ArrayList<>(bourseProxy.getVirements(ide,"virementProjection").getContent()));
        return etudiant;
    }
    
}