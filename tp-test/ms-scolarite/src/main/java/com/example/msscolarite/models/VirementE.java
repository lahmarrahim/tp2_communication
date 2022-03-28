package com.example.msscolarite.models;

import lombok.Data;

import java.util.Date;

@Data
public class VirementE {
    private Long idVirement;
    private Date dateVirement;
    private Long NCompteCCP;
}
