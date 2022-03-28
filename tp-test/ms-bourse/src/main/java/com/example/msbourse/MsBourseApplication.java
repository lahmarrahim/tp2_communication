package com.example.msbourse;

import com.example.msbourse.entities.Etudiant;
import com.example.msbourse.entities.Virement;
import com.example.msbourse.repository.EtudiantRepository;
import com.example.msbourse.repository.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
public class MsBourseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MsBourseApplication.class, args);
    }

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    VirementRepository virementRepository;

    @Override
    public void run(String... args) throws Exception {
        Etudiant e1 = etudiantRepository.save(new Etudiant(1L, 777L, 7000f, false, null));
        Etudiant e2 = etudiantRepository.save(new Etudiant(2L, 666L, 6000f, false, null));
        Etudiant e3 = etudiantRepository.save(new Etudiant(3L, 555L, 5000f, true, null));
        Etudiant e4 = etudiantRepository.save(new Etudiant(4L, 444L, 4000f, false, null));

        virementRepository.save(new Virement(null, 2000f, Date.valueOf("2022-03-07"), e1));
        virementRepository.save(new Virement(null, 3000f, Date.valueOf("2022-03-10"), e1));
        virementRepository.save(new Virement(null, 5000f, Date.valueOf("2022-02-07"), e2));
        virementRepository.save(new Virement(null, 2000f, Date.valueOf("2022-03-08"), e2));
        virementRepository.save(new Virement(null, 3000f, Date.valueOf("2022-03-11"), e2));
        virementRepository.save(new Virement(null, 8000f, Date.valueOf("2022-01-07"), e3));
        virementRepository.save(new Virement(null, 5000f, Date.valueOf("2022-01-17"), e4));
        virementRepository.save(new Virement(null, 1000f, Date.valueOf("2022-02-01"), e4));

    }

}
