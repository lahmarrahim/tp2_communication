package com.example.msscolarite.proxy;

import com.example.msscolarite.models.VirementE;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ms-bourse" , url="localhost:8083")
public interface BourseProxy {

    @GetMapping("/virements/search/findVirementsByEtudiant_IdEtudiant")
    CollectionModel<VirementE> getVirements(@RequestParam("ide") Long ide,
                                            @RequestParam("projection") String p);

}
