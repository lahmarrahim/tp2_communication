package com.example.msscolarite.entities;

import com.example.msscolarite.models.Formation;
import com.example.msscolarite.models.VirementE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    private String promo;
    @ManyToOne
    private Etablissement etablissement;
    private Long idFormation;

    @Transient
    private Formation formation;

    @Transient
    private Collection<VirementE> Virements;
}
