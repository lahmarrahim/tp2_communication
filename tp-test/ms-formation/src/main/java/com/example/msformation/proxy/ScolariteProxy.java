package com.example.msformation.proxy;

import com.example.msformation.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ms-scolarite", url="localhost:8082")
public interface ScolariteProxy {
    @GetMapping("/etudiants/search/findEtudiantByIdFormation")
    CollectionModel<Student> getEtudiants(@RequestParam("idf") Long idf,
                                          @RequestParam("projection") String p);
}
