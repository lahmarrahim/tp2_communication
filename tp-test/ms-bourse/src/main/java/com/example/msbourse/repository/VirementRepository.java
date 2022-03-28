package com.example.msbourse.repository;

import com.example.msbourse.entities.Etudiant;
import com.example.msbourse.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VirementRepository extends JpaRepository<Virement,Long> {
    List<Virement> findVirementsByEtudiant_IdEtudiant(Long ide);
}
