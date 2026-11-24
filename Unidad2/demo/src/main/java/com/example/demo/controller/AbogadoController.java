package com.example.demo.controller;


import com.example.demo.entity.Abogados;
import com.example.demo.repository.AbogadoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AbogadoController {

    @Autowired
    private AbogadoRepositorie abRep;

    @GetMapping("/abogados")
    public List<Abogados> lista(){
   return abRep.findAll();
    }
}
