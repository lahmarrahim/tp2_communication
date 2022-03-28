package com.example.msbourse.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    @Id
    private Long idEtudiant;
    private Long nCompteCCP;
    private Float salaireParant;
    private Boolean situationImpot;

    @OneToMany(mappedBy = "etudiant")
    private Collection<Virement> virements;

}